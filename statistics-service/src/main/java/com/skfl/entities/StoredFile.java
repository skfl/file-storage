package com.skfl.entities;


import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.Instant;

@Entity
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "stored_file")
public class StoredFile {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(name = "uuid")
    String uuid;

    @Column(name = "name")
    String name;

    @Column(name = "size")
    int size;

    @Column(name = "extension")
    String extension;

    @Column(name = "uploaded_at")
    @Temporal(value = TemporalType.TIMESTAMP)
    Instant uploadedAt;
}
