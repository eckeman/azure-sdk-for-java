/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator 1.0.0.0
 * Changes may cause incorrect behavior and will be lost if the code is
 * regenerated.
 */

package com.microsoft.azure.management.recoveryservices.backup.v2016_06_01.implementation;

import com.microsoft.azure.management.recoveryservices.backup.v2016_06_01.BackupManagementType;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.annotation.JsonSubTypes;

/**
 * The base class for a container with backup items. Containers with specific
 * workloads are derived from this class.
 */
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "protectableObjectType")
@JsonTypeName("ProtectionContainer")
@JsonSubTypes({
    @JsonSubTypes.Type(name = "AzureSqlContainer", value = AzureSqlContainer.class),
    @JsonSubTypes.Type(name = "IaaSVMContainer", value = IaaSVMContainer.class),
    @JsonSubTypes.Type(name = "MABWindowsContainer", value = MabContainer.class)
})
public class ProtectionContainerInner {
    /**
     * Friendly name of the container.
     */
    @JsonProperty(value = "friendlyName")
    private String friendlyName;

    /**
     * The backup management type for the container. Possible values include:
     * 'Invalid', 'AzureIaasVM', 'MAB', 'DPM', 'AzureBackupServer', 'AzureSql'.
     */
    @JsonProperty(value = "backupManagementType")
    private BackupManagementType backupManagementType;

    /**
     * The container's registration status with the Recovery Services vault.
     */
    @JsonProperty(value = "registrationStatus")
    private String registrationStatus;

    /**
     * The status of the container's health.
     */
    @JsonProperty(value = "healthStatus")
    private String healthStatus;

    /**
     * The type assigned to the container. The values to use for each of these
     * properties are:&lt;br/&gt; 1. Compute Azure VM is
     * Microsoft.Compute/virtualMachines&lt;br/&gt; 2. Classic Compute Azure VM
     * is Microsoft.ClassicCompute/virtualMachines&lt;br/&gt; 3. Windows
     * machines (like Azure Backup Server and DPM) is Windows&lt;br/&gt; 4.
     * Azure SQL instance is AzureSqlContainer.
     */
    @JsonProperty(value = "containerType", access = JsonProperty.Access.WRITE_ONLY)
    private String containerType;

    /**
     * Get friendly name of the container.
     *
     * @return the friendlyName value
     */
    public String friendlyName() {
        return this.friendlyName;
    }

    /**
     * Set friendly name of the container.
     *
     * @param friendlyName the friendlyName value to set
     * @return the ProtectionContainerInner object itself.
     */
    public ProtectionContainerInner withFriendlyName(String friendlyName) {
        this.friendlyName = friendlyName;
        return this;
    }

    /**
     * Get the backup management type for the container. Possible values include: 'Invalid', 'AzureIaasVM', 'MAB', 'DPM', 'AzureBackupServer', 'AzureSql'.
     *
     * @return the backupManagementType value
     */
    public BackupManagementType backupManagementType() {
        return this.backupManagementType;
    }

    /**
     * Set the backup management type for the container. Possible values include: 'Invalid', 'AzureIaasVM', 'MAB', 'DPM', 'AzureBackupServer', 'AzureSql'.
     *
     * @param backupManagementType the backupManagementType value to set
     * @return the ProtectionContainerInner object itself.
     */
    public ProtectionContainerInner withBackupManagementType(BackupManagementType backupManagementType) {
        this.backupManagementType = backupManagementType;
        return this;
    }

    /**
     * Get the container's registration status with the Recovery Services vault.
     *
     * @return the registrationStatus value
     */
    public String registrationStatus() {
        return this.registrationStatus;
    }

    /**
     * Set the container's registration status with the Recovery Services vault.
     *
     * @param registrationStatus the registrationStatus value to set
     * @return the ProtectionContainerInner object itself.
     */
    public ProtectionContainerInner withRegistrationStatus(String registrationStatus) {
        this.registrationStatus = registrationStatus;
        return this;
    }

    /**
     * Get the status of the container's health.
     *
     * @return the healthStatus value
     */
    public String healthStatus() {
        return this.healthStatus;
    }

    /**
     * Set the status of the container's health.
     *
     * @param healthStatus the healthStatus value to set
     * @return the ProtectionContainerInner object itself.
     */
    public ProtectionContainerInner withHealthStatus(String healthStatus) {
        this.healthStatus = healthStatus;
        return this;
    }

    /**
     * Get the type assigned to the container. The values to use for each of these properties are:&lt;br/&gt; 1. Compute Azure VM is Microsoft.Compute/virtualMachines&lt;br/&gt; 2. Classic Compute Azure VM is Microsoft.ClassicCompute/virtualMachines&lt;br/&gt; 3. Windows machines (like Azure Backup Server and DPM) is Windows&lt;br/&gt; 4. Azure SQL instance is AzureSqlContainer.
     *
     * @return the containerType value
     */
    public String containerType() {
        return this.containerType;
    }

}
