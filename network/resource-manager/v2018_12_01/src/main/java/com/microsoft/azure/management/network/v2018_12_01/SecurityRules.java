/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.management.network.v2018_12_01;

import com.microsoft.azure.arm.collection.SupportsCreating;
import rx.Completable;
import rx.Observable;
import com.microsoft.azure.management.network.v2018_12_01.implementation.SecurityRulesInner;
import com.microsoft.azure.arm.model.HasInner;

/**
 * Type representing SecurityRules.
 */
public interface SecurityRules extends SupportsCreating<NetworkSecurityGroupSecurityRule.DefinitionStages.Blank>, HasInner<SecurityRulesInner> {
    /**
     * Get the specified network security rule.
     *
     * @param resourceGroupName The name of the resource group.
     * @param networkSecurityGroupName The name of the network security group.
     * @param securityRuleName The name of the security rule.
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the observable for the request
     */
    Observable<NetworkSecurityGroupSecurityRule> getAsync(String resourceGroupName, String networkSecurityGroupName, String securityRuleName);

    /**
     * Gets all security rules in a network security group.
     *
     * @param resourceGroupName The name of the resource group.
     * @param networkSecurityGroupName The name of the network security group.
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the observable for the request
     */
    Observable<NetworkSecurityGroupSecurityRule> listAsync(final String resourceGroupName, final String networkSecurityGroupName);

    /**
     * Deletes the specified network security rule.
     *
     * @param resourceGroupName The name of the resource group.
     * @param networkSecurityGroupName The name of the network security group.
     * @param securityRuleName The name of the security rule.
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the observable for the request
     */
    Completable deleteAsync(String resourceGroupName, String networkSecurityGroupName, String securityRuleName);

}
