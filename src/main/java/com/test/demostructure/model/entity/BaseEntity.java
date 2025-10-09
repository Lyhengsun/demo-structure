package com.test.demostructure.model.entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.UUID;

public abstract class BaseEntity extends BaseEntityAudit {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
}
