/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.management.recoveryservicessiterecovery.v2018_01_10;

import com.microsoft.azure.arm.model.HasInner;
import com.microsoft.azure.management.recoveryservicessiterecovery.v2018_01_10.implementation.FabricInner;
import com.microsoft.azure.arm.model.Indexable;
import com.microsoft.azure.arm.model.Refreshable;
import com.microsoft.azure.arm.model.Updatable;
import com.microsoft.azure.arm.model.Appliable;
import com.microsoft.azure.arm.model.Creatable;
import com.microsoft.azure.arm.resources.models.HasManager;
import com.microsoft.azure.management.recoveryservicessiterecovery.v2018_01_10.implementation.RecoveryServicesManager;

/**
 * Type representing Fabric.
 */
public interface Fabric extends HasInner<FabricInner>, Indexable, Refreshable<Fabric>, Updatable<Fabric.Update>, HasManager<RecoveryServicesManager> {
    /**
     * @return the id value.
     */
    String id();

    /**
     * @return the location value.
     */
    String location();

    /**
     * @return the name value.
     */
    String name();

    /**
     * @return the properties value.
     */
    FabricProperties properties();

    /**
     * @return the type value.
     */
    String type();

    /**
     * The entirety of the Fabric definition.
     */
    interface Definition extends DefinitionStages.Blank, DefinitionStages.WithVault, DefinitionStages.WithProperties, DefinitionStages.WithCreate {
    }

    /**
     * Grouping of Fabric definition stages.
     */
    interface DefinitionStages {
        /**
         * The first stage of a Fabric definition.
         */
        interface Blank extends WithVault {
        }

        /**
         * The stage of the fabric definition allowing to specify Vault.
         */
        interface WithVault {
           /**
            * Specifies .
            * @return the next definition stage
            */
            WithProperties withExistingVault();
        }

        /**
         * The stage of the fabric definition allowing to specify Properties.
         */
        interface WithProperties {
           /**
            * Specifies properties.
            * @param properties Fabric creation input
            * @return the next definition stage
            */
            WithCreate withProperties(FabricCreationInputProperties properties);
        }

        /**
         * The stage of the definition which contains all the minimum required inputs for
         * the resource to be created (via {@link WithCreate#create()}), but also allows
         * for any other optional settings to be specified.
         */
        interface WithCreate extends Creatable<Fabric> {
        }
    }
    /**
     * The template for a Fabric update operation, containing all the settings that can be modified.
     */
    interface Update extends Appliable<Fabric>, UpdateStages.WithProperties {
    }

    /**
     * Grouping of Fabric update stages.
     */
    interface UpdateStages {
        /**
         * The stage of the fabric update allowing to specify Properties.
         */
        interface WithProperties {
            /**
             * Specifies properties.
             * @param properties Fabric creation input
             * @return the next update stage
             */
            Update withProperties(FabricCreationInputProperties properties);
        }

    }
}
