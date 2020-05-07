package com.thomas.spotitube.data;

import com.thomas.spotitube.domain.User;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class TrackDaoTest {
    @InjectMocks
    private TrackDao trackDao;

    @Mock
    private Connection c;

    @Mock
    private PreparedStatement stmt;

    @Mock
    private ResultSet rs;

    private TrackDao trackDaoMock;

    private User user;
    private String query;
    private String token;
    private int userId;

    @Before
    public void setup() throws SQLException {
        query = "Some SQL Query";
        token = "1234-1234-1234-1234";
        userId = 1;
        user = new User(1, "admin", token);
        user.setPassword("password");

        trackDaoMock = Mockito.spy(trackDao);
        doReturn(query).when(trackDaoMock).getQuery(anyString());
        doReturn(c).when(trackDaoMock).getConnection();

        when(c.prepareStatement(anyString())).thenReturn(stmt);
        when(stmt.executeQuery()).thenReturn(rs);
        when(rs.next()).thenReturn(true);
    }

    @Test
    public void init() {
        assertNotNull(trackDaoMock);
        assertNotNull(c);
        assertNotNull(stmt);
        assertNotNull(rs);
    }
}
