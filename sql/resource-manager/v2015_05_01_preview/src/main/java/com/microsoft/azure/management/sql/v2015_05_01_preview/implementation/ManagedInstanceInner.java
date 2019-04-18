/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.management.sql.v2015_05_01_preview.implementation;

import com.microsoft.azure.management.sql.v2015_05_01_preview.ResourceIdentity;
import com.microsoft.azure.management.sql.v2015_05_01_preview.Sku;
import com.microsoft.azure.management.sql.v2015_05_01_preview.ManagedInstanceProxyOverride;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.microsoft.rest.serializer.JsonFlatten;
import com.microsoft.azure.Resource;

/**
 * An Azure SQL managed instance.
 */
@JsonFlatten
public class ManagedInstanceInner extends Resource {
    /**
     * The Azure Active Directory identity of the managed instance.
     */
    @JsonProperty(value = "identity")
    private ResourceIdentity identity;

    /**
     * Managed instance sku.
     */
    @JsonProperty(value = "sku")
    private Sku sku;

    /**
     * The fully qualified domain name of the managed instance.
     */
    @JsonProperty(value = "properties.fullyQualifiedDomainName", access = JsonProperty.Access.WRITE_ONLY)
    private String fullyQualifiedDomainName;

    /**
     * Administrator username for the managed instance. Can only be specified
     * when the managed instance is being created (and is required for
     * creation).
     */
    @JsonProperty(value = "properties.administratorLogin")
    private String administratorLogin;

    /**
     * The administrator login password (required for managed instance
     * creation).
     */
    @JsonProperty(value = "properties.administratorLoginPassword")
    private String administratorLoginPassword;

    /**
     * Subnet resource ID for the managed instance.
     */
    @JsonProperty(value = "properties.subnetId")
    private String subnetId;

    /**
     * The state of the managed instance.
     */
    @JsonProperty(value = "properties.state", access = JsonProperty.Access.WRITE_ONLY)
    private String state;

    /**
     * The license type. Possible values are 'LicenseIncluded' and 'BasePrice'.
     */
    @JsonProperty(value = "properties.licenseType")
    private String licenseType;

    /**
     * The number of VCores.
     */
    @JsonProperty(value = "properties.vCores")
    private Integer vCores;

    /**
     * The maximum storage size in GB.
     */
    @JsonProperty(value = "properties.storageSizeInGB")
    private Integer storageSizeInGB;

    /**
     * Collation of the managed instance.
     */
    @JsonProperty(value = "properties.collation")
    private String collation;

    /**
     * The Dns Zone that the managed instance is in.
     */
    @JsonProperty(value = "properties.dnsZone", access = JsonProperty.Access.WRITE_ONLY)
    private String dnsZone;

    /**
     * The resource id of another managed instance whose DNS zone this managed
     * instance will share after creation.
     */
    @JsonProperty(value = "properties.dnsZonePartner")
    private String dnsZonePartner;

    /**
     * Whether or not the public data endpoint is enabled.
     */
    @JsonProperty(value = "properties.publicDataEndpointEnabled")
    private Boolean publicDataEndpointEnabled;

    /**
     * Connection type used for connecting to the instance. Possible values
     * include: 'Proxy', 'Redirect', 'Default'.
     */
    @JsonProperty(value = "properties.proxyOverride")
    private ManagedInstanceProxyOverride proxyOverride;

    /**
     * Id of the timezone. Allowed values are timezones supported by Windows.
     * Windows keeps details on supported timezones, including the id, in
     * registry under
     * KEY_LOCAL_MACHINE\SOFTWARE\Microsoft\Windows NT\CurrentVersion\Time
     * Zones.
     * You can get those registry values via SQL Server by querying SELECT name
     * AS timezone_id FROM sys.time_zone_info.
     * List of Ids can also be obtained by executing
     * [System.TimeZoneInfo]::GetSystemTimeZones() in PowerShell.
     * An example of valid timezone id is "Pacific Standard Time" or "W. Europe
     * Standard Time".
     */
    @JsonProperty(value = "properties.timezoneId")
    private String timezoneId;

    /**
     * Get the Azure Active Directory identity of the managed instance.
     *
     * @return the identity value
     */
    public ResourceIdentity identity() {
        return this.identity;
    }

    /**
     * Set the Azure Active Directory identity of the managed instance.
     *
     * @param identity the identity value to set
     * @return the ManagedInstanceInner object itself.
     */
    public ManagedInstanceInner withIdentity(ResourceIdentity identity) {
        this.identity = identity;
        return this;
    }

    /**
     * Get managed instance sku.
     *
     * @return the sku value
     */
    public Sku sku() {
        return this.sku;
    }

    /**
     * Set managed instance sku.
     *
     * @param sku the sku value to set
     * @return the ManagedInstanceInner object itself.
     */
    public ManagedInstanceInner withSku(Sku sku) {
        this.sku = sku;
        return this;
    }

    /**
     * Get the fully qualified domain name of the managed instance.
     *
     * @return the fullyQualifiedDomainName value
     */
    public String fullyQualifiedDomainName() {
        return this.fullyQualifiedDomainName;
    }

    /**
     * Get administrator username for the managed instance. Can only be specified when the managed instance is being created (and is required for creation).
     *
     * @return the administratorLogin value
     */
    public String administratorLogin() {
        return this.administratorLogin;
    }

    /**
     * Set administrator username for the managed instance. Can only be specified when the managed instance is being created (and is required for creation).
     *
     * @param administratorLogin the administratorLogin value to set
     * @return the ManagedInstanceInner object itself.
     */
    public ManagedInstanceInner withAdministratorLogin(String administratorLogin) {
        this.administratorLogin = administratorLogin;
        return this;
    }

    /**
     * Get the administrator login password (required for managed instance creation).
     *
     * @return the administratorLoginPassword value
     */
    public String administratorLoginPassword() {
        return this.administratorLoginPassword;
    }

    /**
     * Set the administrator login password (required for managed instance creation).
     *
     * @param administratorLoginPassword the administratorLoginPassword value to set
     * @return the ManagedInstanceInner object itself.
     */
    public ManagedInstanceInner withAdministratorLoginPassword(String administratorLoginPassword) {
        this.administratorLoginPassword = administratorLoginPassword;
        return this;
    }

    /**
     * Get subnet resource ID for the managed instance.
     *
     * @return the subnetId value
     */
    public String subnetId() {
        return this.subnetId;
    }

    /**
     * Set subnet resource ID for the managed instance.
     *
     * @param subnetId the subnetId value to set
     * @return the ManagedInstanceInner object itself.
     */
    public ManagedInstanceInner withSubnetId(String subnetId) {
        this.subnetId = subnetId;
        return this;
    }

    /**
     * Get the state of the managed instance.
     *
     * @return the state value
     */
    public String state() {
        return this.state;
    }

    /**
     * Get the license type. Possible values are 'LicenseIncluded' and 'BasePrice'.
     *
     * @return the licenseType value
     */
    public String licenseType() {
        return this.licenseType;
    }

    /**
     * Set the license type. Possible values are 'LicenseIncluded' and 'BasePrice'.
     *
     * @param licenseType the licenseType value to set
     * @return the ManagedInstanceInner object itself.
     */
    public ManagedInstanceInner withLicenseType(String licenseType) {
        this.licenseType = licenseType;
        return this;
    }

    /**
     * Get the number of VCores.
     *
     * @return the vCores value
     */
    public Integer vCores() {
        return this.vCores;
    }

    /**
     * Set the number of VCores.
     *
     * @param vCores the vCores value to set
     * @return the ManagedInstanceInner object itself.
     */
    public ManagedInstanceInner withVCores(Integer vCores) {
        this.vCores = vCores;
        return this;
    }

    /**
     * Get the maximum storage size in GB.
     *
     * @return the storageSizeInGB value
     */
    public Integer storageSizeInGB() {
        return this.storageSizeInGB;
    }

    /**
     * Set the maximum storage size in GB.
     *
     * @param storageSizeInGB the storageSizeInGB value to set
     * @return the ManagedInstanceInner object itself.
     */
    public ManagedInstanceInner withStorageSizeInGB(Integer storageSizeInGB) {
        this.storageSizeInGB = storageSizeInGB;
        return this;
    }

    /**
     * Get collation of the managed instance.
     *
     * @return the collation value
     */
    public String collation() {
        return this.collation;
    }

    /**
     * Set collation of the managed instance.
     *
     * @param collation the collation value to set
     * @return the ManagedInstanceInner object itself.
     */
    public ManagedInstanceInner withCollation(String collation) {
        this.collation = collation;
        return this;
    }

    /**
     * Get the Dns Zone that the managed instance is in.
     *
     * @return the dnsZone value
     */
    public String dnsZone() {
        return this.dnsZone;
    }

    /**
     * Get the resource id of another managed instance whose DNS zone this managed instance will share after creation.
     *
     * @return the dnsZonePartner value
     */
    public String dnsZonePartner() {
        return this.dnsZonePartner;
    }

    /**
     * Set the resource id of another managed instance whose DNS zone this managed instance will share after creation.
     *
     * @param dnsZonePartner the dnsZonePartner value to set
     * @return the ManagedInstanceInner object itself.
     */
    public ManagedInstanceInner withDnsZonePartner(String dnsZonePartner) {
        this.dnsZonePartner = dnsZonePartner;
        return this;
    }

    /**
     * Get whether or not the public data endpoint is enabled.
     *
     * @return the publicDataEndpointEnabled value
     */
    public Boolean publicDataEndpointEnabled() {
        return this.publicDataEndpointEnabled;
    }

    /**
     * Set whether or not the public data endpoint is enabled.
     *
     * @param publicDataEndpointEnabled the publicDataEndpointEnabled value to set
     * @return the ManagedInstanceInner object itself.
     */
    public ManagedInstanceInner withPublicDataEndpointEnabled(Boolean publicDataEndpointEnabled) {
        this.publicDataEndpointEnabled = publicDataEndpointEnabled;
        return this;
    }

    /**
     * Get connection type used for connecting to the instance. Possible values include: 'Proxy', 'Redirect', 'Default'.
     *
     * @return the proxyOverride value
     */
    public ManagedInstanceProxyOverride proxyOverride() {
        return this.proxyOverride;
    }

    /**
     * Set connection type used for connecting to the instance. Possible values include: 'Proxy', 'Redirect', 'Default'.
     *
     * @param proxyOverride the proxyOverride value to set
     * @return the ManagedInstanceInner object itself.
     */
    public ManagedInstanceInner withProxyOverride(ManagedInstanceProxyOverride proxyOverride) {
        this.proxyOverride = proxyOverride;
        return this;
    }

    /**
     * Get id of the timezone. Allowed values are timezones supported by Windows.
     Windows keeps details on supported timezones, including the id, in registry under
     KEY_LOCAL_MACHINE\SOFTWARE\Microsoft\Windows NT\CurrentVersion\Time Zones.
     You can get those registry values via SQL Server by querying SELECT name AS timezone_id FROM sys.time_zone_info.
     List of Ids can also be obtained by executing [System.TimeZoneInfo]::GetSystemTimeZones() in PowerShell.
     An example of valid timezone id is "Pacific Standard Time" or "W. Europe Standard Time".
     *
     * @return the timezoneId value
     */
    public String timezoneId() {
        return this.timezoneId;
    }

    /**
     * Set id of the timezone. Allowed values are timezones supported by Windows.
     Windows keeps details on supported timezones, including the id, in registry under
     KEY_LOCAL_MACHINE\SOFTWARE\Microsoft\Windows NT\CurrentVersion\Time Zones.
     You can get those registry values via SQL Server by querying SELECT name AS timezone_id FROM sys.time_zone_info.
     List of Ids can also be obtained by executing [System.TimeZoneInfo]::GetSystemTimeZones() in PowerShell.
     An example of valid timezone id is "Pacific Standard Time" or "W. Europe Standard Time".
     *
     * @param timezoneId the timezoneId value to set
     * @return the ManagedInstanceInner object itself.
     */
    public ManagedInstanceInner withTimezoneId(String timezoneId) {
        this.timezoneId = timezoneId;
        return this;
    }

}
