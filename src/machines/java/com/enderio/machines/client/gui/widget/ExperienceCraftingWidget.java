package com.enderio.machines.client.gui.widget;

import com.enderio.base.common.util.ExperienceUtil;
import com.enderio.core.client.gui.widgets.EIOWidget;
import com.enderio.machines.common.io.fluid.MachineFluidTank;
import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.narration.NarrationElementOutput;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;

import java.util.function.Supplier;

public class ExperienceCraftingWidget extends EIOWidget {
    protected static final ResourceLocation EXPERIENCE_BAR_BACKGROUND_SPRITE = new ResourceLocation("hud/experience_bar_background");
    protected static final ResourceLocation EXPERIENCE_BAR_PROGRESS_SPRITE = new ResourceLocation("hud/experience_bar_progress");
    private final Screen screen;
    private final Supplier<MachineFluidTank> getFluid;
    private final Supplier<Integer> maxXP;

    public ExperienceCraftingWidget(Screen screen, Supplier<MachineFluidTank> getFluid, Supplier<Integer> maxXP, int pX, int pY, int pWidth, int pHeight) {
        super(pX, pY, pWidth, pHeight);
        this.screen = screen;
        this.getFluid = getFluid;
        this.maxXP = maxXP;
    }

    @Override
    public void renderWidget(GuiGraphics guiGraphics, int pMouseX, int pMouseY, float pPartialTick) {
        RenderSystem.defaultBlendFunc();
        RenderSystem.enableDepthTest();

        int k = 1;
        if (maxXP.get() > 0) {
            k = (int) (((getFluid.get().getFluidAmount() / ((float) ExperienceUtil.getFluidFromLevel(maxXP.get()))) * this.width)-1);
            if (k > this.width-1) {
                k = this.width-1;
            }
        }

        guiGraphics.blitSprite(EXPERIENCE_BAR_BACKGROUND_SPRITE, this.x, this.y, this.width, this.height);
        guiGraphics.blitSprite(EXPERIENCE_BAR_PROGRESS_SPRITE, 182, 5, 0, 0, this.x, this.y, k, 5);

        var font = Minecraft.getInstance().font;
        String s = "" + maxXP.get();
        guiGraphics.drawString(font, s, (this.x + this.width/2 + 1), (float)this.y - this.height - 3, 0, false);
        guiGraphics.drawString(font, s, (this.x + this.width/2 - 1), (float)this.y - this.height - 3, 0, false);
        guiGraphics.drawString(font, s, this.x + this.width/2, (float)(this.y - this.height - 3 + 1), 0, false);
        guiGraphics.drawString(font, s, this.x + this.width/2, (float)(this.y - this.height - 3 - 1), 0, false);
        guiGraphics.drawString(font, s, this.x + this.width/2, (float)this.y - this.height - 3, 8453920, false);

        if (isHovered(pMouseX, pMouseY)) {
            guiGraphics.renderTooltip(screen.getMinecraft().font,
                Component.literal(getFluid.get().getFluidAmount() + " mb / " + ExperienceUtil.getFluidFromLevel(maxXP.get()) + " mb"), pMouseX, pMouseY);
        }
    }

    @Override
    protected void updateWidgetNarration(NarrationElementOutput pNarrationElementOutput) {
    }
}
