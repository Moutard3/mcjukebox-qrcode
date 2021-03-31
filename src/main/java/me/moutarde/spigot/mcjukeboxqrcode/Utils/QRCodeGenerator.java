package me.moutarde.spigot.mcjukeboxqrcode.Utils;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.Writer;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import lombok.RequiredArgsConstructor;
import me.moutarde.spigot.mcjukeboxqrcode.MCJukeboxQRCode;
import net.mcjukebox.plugin.bukkit.api.JukeboxAPI;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.awt.image.BufferedImage;
import java.util.logging.Level;

@RequiredArgsConstructor
public class QRCodeGenerator implements Runnable {
    private static final int MINECRAFT_MAP_SIZE = 128;

    private final Player player;

    @Override
    public void run() {
        Writer qrWriter = new QRCodeWriter();

        try {
            String contents = MCJukeboxQRCode.getMcJukebox().getLangManager().get("user.openDomain") + "?token=" + JukeboxAPI.getToken(this.player);
            BitMatrix encode = qrWriter.encode(contents, BarcodeFormat.QR_CODE, MINECRAFT_MAP_SIZE, MINECRAFT_MAP_SIZE);
            BufferedImage resultImage = MatrixToImageWriter.toBufferedImage(encode);

            Bukkit.getScheduler().runTask(MCJukeboxQRCode.getPlugin(), new QRCodeGiver(player, resultImage));
        } catch (WriterException writeEx) {
            MCJukeboxQRCode.getPlugin().getLogger().log(Level.SEVERE, "Tried downloading image", writeEx);
        }
    }
}
