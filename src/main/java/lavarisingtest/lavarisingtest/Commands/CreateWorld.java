package lavarisingtest.lavarisingtest.Commands;

import lavarisingtest.lavarisingtest.LavaRisingTest;
import org.bukkit.*;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.Random;

public class CreateWorld implements CommandExecutor {

    // This method is called, when somebody uses our command
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        String randomLavaNumberWorld = Integer.toString(new Random().nextInt(99999999));
        while (Bukkit.getWorld(randomLavaNumberWorld.toString()) != null) {
            randomLavaNumberWorld = Integer.toString(new Random().nextInt(99999999));
        }
        WorldCreator wc = new WorldCreator(randomLavaNumberWorld);
        wc.hardcore(true);
        wc.generatorSettings("{\"useCaves\":true,\"useStrongholds\":true,\"useVillages\":true,\"useMineShafts\":true,\"useTemples\":true,\"useRavines\":true,\"useMonuments\":true,\"useMansions\":true,\"useLavaOceans\":false,\"useWaterLakes\":true,\"useLavaLakes\":true,\"useDungeons\":true,\"fixedBiome\":-3,\"biomeSize\":4,\"seaLevel\":63,\"riverSize\":4,\"waterLakeChance\":50,\"lavaLakeChance\":40,\"dungeonChance\":8,\"dirtSize\":33,\"dirtCount\":10,\"dirtMinHeight\":0,\"dirtMaxHeight\":255,\"gravelSize\":33,\"gravelCount\":10,\"gravelMinHeight\":0,\"gravelMaxHeight\":255,\"graniteSize\":33,\"graniteCount\":10,\"graniteMinHeight\":0,\"graniteMaxHeight\":80,\"dioriteSize\":33,\"dioriteCount\":10,\"dioriteMinHeight\":0,\"dioriteMaxHeight\":80,\"andesiteSize\":33,\"andesiteCount\":10,\"andesiteMinHeight\":0,\"andesiteMaxHeight\":80,\"coalSize\":30,\"coalCount\":36,\"coalMinHeight\":0,\"coalMaxHeight\":128,\"ironSize\":26,\"ironCount\":30,\"ironMinHeight\":0,\"ironMaxHeight\":72,\"goldSize\":30,\"goldCount\":26,\"goldMinHeight\":0,\"goldMaxHeight\":57,\"redstoneSize\":8,\"redstoneCount\":8,\"redstoneMinHeight\":0,\"redstoneMaxHeight\":16,\"diamondSize\":32,\"diamondCount\":10,\"diamondMinHeight\":0,\"diamondMaxHeight\":37,\"lapisSize\":18,\"lapisCount\":8,\"lapisMinHeight\":0,\"lapisMaxHeight\":32,\"coordinateScale\":738,\"heightScale\":158,\"mainNoiseScaleX\":1356,\"mainNoiseScaleY\":746,\"mainNoiseScaleZ\":1183,\"depthNoiseScaleX\":375,\"depthNoiseScaleZ\":289,\"depthNoiseScaleExponent\":1.21,\"biomeDepthWeight\":1.8,\"biomeDepthOffset\":3.5,\"biomeScaleWeight\":1,\"biomeScaleOffset\":2.5,\"lowerLimitScale\":1254,\"upperLimitScale\":801,\"baseSize\":1.9,\"stretchY\":1.71,\"lapisCenterHeight\":16,\"lapisSpread\":16}");
        World w = Bukkit.createWorld(wc);
        w.getWorldBorder().setCenter(0,0);
        w.getWorldBorder().setSize(400);
        w.setSpawnLocation(w.getHighestBlockAt(0,0).getLocation());
        for (Player p : Bukkit.getOnlinePlayers()) {
            p.teleport(w.getSpawnLocation());
            p.sendTitle(LavaRisingTest.mm.deserialize("<gradient:#ff7f4d:#ff4400><b><i>Lava Rising Event</i></b><gradient>").toString(), "");
            p.playSound(p, Sound.BLOCK_BEACON_ACTIVATE, 1, 1);
        }
        return true;
    }
}