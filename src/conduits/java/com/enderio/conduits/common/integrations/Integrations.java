package com.enderio.conduits.common.integrations;

import com.enderio.api.integration.IntegrationManager;
import com.enderio.api.integration.IntegrationWrapper;
import com.enderio.conduits.common.integrations.ae2.AE2Integration;
import com.enderio.conduits.common.integrations.cctweaked.CCIntegration;
import com.enderio.conduits.common.integrations.mekanism.MekanismIntegration;
import com.enderio.conduits.common.integrations.refinedstorage.RSIntegration;

public class Integrations {

    public static final IntegrationWrapper<AE2Integration> AE2_INTEGRATION = IntegrationManager.wrapper("ae2", () -> AE2Integration::new);
    public static final IntegrationWrapper<MekanismIntegration> MEKANISM_INTEGRATION = IntegrationManager.wrapper("mekanism", () -> MekanismIntegration::new);
    public static final IntegrationWrapper<CCIntegration> CC_INTEGRATION = IntegrationManager.wrapper("computercraft", () -> CCIntegration::new);
    public static final IntegrationWrapper<RSIntegration> RS_INTEGRATION = IntegrationManager.wrapper("refinedstorage", () -> RSIntegration::new);

    public static final IntegrationWrapper<ConduitSelfIntegration> SELF_INTEGRATION = IntegrationManager.wrapper("enderio", () -> ConduitSelfIntegration::new);

    public static void register() {
    }
}
