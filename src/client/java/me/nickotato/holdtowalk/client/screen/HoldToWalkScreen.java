package me.nickotato.holdtowalk.client.screen;

import me.nickotato.holdtowalk.client.HoldToWalkClient;
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
                                        getText(),
                                        button -> {
                                            HoldToWalkClient.config.enabled =
                                                    !HoldToWalkClient.config.enabled;

                                            button.setMessage(getText());
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

            private Text getText() {
                return Text.literal(
                        "Enabled: " +
                                HoldToWalkClient.config.enabled
                );
            }
        };
    }

}
