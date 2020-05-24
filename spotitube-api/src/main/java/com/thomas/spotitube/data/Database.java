package com.thomas.spotitube.data;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;
import com.thomas.spotitube.data.interfaces.IDatabase;
import com.thomas.spotitube.data.properties.SingletonDatabaseProperties;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;

import static org.bson.codecs.configuration.CodecRegistries.fromProviders;
import static org.bson.codecs.configuration.CodecRegistries.fromRegistries;

public abstract class Database implements IDatabase {
    protected MongoClient client;
    protected MongoDatabase database;
    protected SingletonDatabaseProperties props;

    public Database() {
        props = SingletonDatabaseProperties.getInstance();
        connect();
    }

    public void connect() {
        ConnectionString connectionString = new ConnectionString(props.connectionString());

        CodecRegistry pojoCodecRegistry = fromProviders(PojoCodecProvider.builder()
                .automatic(true)
                .build());

        CodecRegistry codecRegistry = fromRegistries(
                MongoClientSettings.getDefaultCodecRegistry(),
                pojoCodecRegistry
        );

        MongoClientSettings clientSettings = MongoClientSettings.builder()
                .applyConnectionString(connectionString)
                .codecRegistry(codecRegistry)
                .build();

        client = MongoClients.create(clientSettings);
        database = client.getDatabase(props.database());
    }

    public MongoDatabase getDatabase() {
        return database;
    }
}
