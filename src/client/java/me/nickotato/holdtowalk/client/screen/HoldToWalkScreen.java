package me.nickotato.holdtowalk.client.screen;

import me.nickotato.holdtowalk.client.HoldToWalkClient;
import me.nickotato.holdtowalk.client.enums.WalkMode;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.text.Text;

public class HoldToWalkScreen {
    public static Screen create(Screen parent) {

        return new Screen(Text.literal("Hold To Walk")) {

            @Override
            protected void init() {

                addDrawableChild(
                        ButtonWidget.builder(
                                        getModeText(),
                                        button -> {
                                            nextMode();
                                            button.setMessage(getModeText());
                                        }
                                )
                                .dimensions(
                                        width / 2 - 100,
                                        height / 2,
                                        200,
                                        20
                                )
                                .build()
                );
            }

            @Override
            public void render(DrawContext context, int mouseX, int mouseY, float delta) {
                super.render(context, mouseX, mouseY, delta);

                if (HoldToWalkClient.config.mode == WalkMode.RESPONSIVE) {


                    context.drawCenteredTextWithShadow(
                            textRenderer,
                            Text.literal("§eResponsive mode differs from vanilla sprint behavior."),
                            width / 2,
                            height / 2 + 35,
                            0xFFFFFF55
                    );

                    context.drawCenteredTextWithShadow(
                            textRenderer,
                            Text.literal("§7Some competitive servers may not allow it."),
                            width / 2,
                            height / 2 + 47,
                            0xFFAAAAAA
                    );

                }
            }

            private void nextMode() {
                switch (HoldToWalkClient.config.mode) {
                    case OFF -> HoldToWalkClient.config.mode = WalkMode.VANILLA;
                    case VANILLA -> HoldToWalkClient.config.mode = WalkMode.RESPONSIVE;
                    case RESPONSIVE -> HoldToWalkClient.config.mode = WalkMode.OFF;
                }
            }

            private Text getModeText() {
                return switch (HoldToWalkClient.config.mode) {
                    case OFF -> Text.literal("Mode: Disabled");
                    case VANILLA -> Text.literal("Mode: Vanilla-Compatible");
                    case RESPONSIVE -> Text.literal("Mode: Responsive");
                };
            }
        };
    }



}
