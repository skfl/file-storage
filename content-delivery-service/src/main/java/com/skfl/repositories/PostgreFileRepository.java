package com.skfl.repositories;

import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.io.BufferedInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@Repository
@RequiredArgsConstructor
public class PostgreFileRepository {

    private static final String STORE_FILE = "INSERT INTO store VALUES ( ?, ? )";
    private static final String GET_FILE = "SELECT data from store WHERE uuid = ?";
    private final JdbcTemplate jdbcTemplate;

    public void storeFile(InputStream inputStream, String uuid) {
        try (Connection connection = jdbcTemplate.getDataSource().getConnection()) {
            PreparedStatement ps = connection.prepareStatement(STORE_FILE);
            ps.setString(1, uuid);
            ps.setBinaryStream(2, inputStream);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public InputStream getFile(String uuid) {
        try (Connection connection = jdbcTemplate.getDataSource().getConnection()) {
            PreparedStatement ps = connection.prepareStatement(GET_FILE);
            ps.setString(1,uuid);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return new BufferedInputStream(rs.getBinaryStream(1));
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return InputStream.nullInputStream();
    }
}
