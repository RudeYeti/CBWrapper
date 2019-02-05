package misson20000.plugins.cbwrapper;

import java.net.InetSocketAddress;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

import org.bukkit.*;
import org.bukkit.advancement.Advancement;
import org.bukkit.advancement.AdvancementProgress;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeInstance;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.block.PistonMoveReaction;
import org.bukkit.block.data.BlockData;
import org.bukkit.conversations.Conversation;
import org.bukkit.conversations.ConversationAbandonedEvent;
import org.bukkit.entity.*;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.player.PlayerTeleportEvent.TeleportCause;
import org.bukkit.inventory.*;
import org.bukkit.inventory.InventoryView.Property;
import org.bukkit.map.MapView;
import org.bukkit.metadata.MetadataValue;
import org.bukkit.permissions.Permission;
import org.bukkit.permissions.PermissionAttachment;
import org.bukkit.permissions.PermissionAttachmentInfo;
import org.bukkit.plugin.Plugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.util.Vector;

public class DummyPlayer implements Player {

    private Server server;
    private double x;
    private double y;
    private double z;
    private World world;
    private String name;
    private UUID uuid;
    
    public DummyPlayer(String name, Server server, World world, int x, int y, int z) {
        this.server = server;
        this.world = world;
        this.x = x;
        this.y = y;
        this.z = z;
        this.name = name;
        this.uuid = UUID.nameUUIDFromBytes(name.getBytes());
    }
    @Override public void closeInventory() {}
    @Override public Inventory getEnderChest() { return null; }

    @Override
    public MainHand getMainHand() {
        return null;
    }

    @Override public int getExpToLevel() { return 0; }

    @Override
    public boolean discoverRecipe(NamespacedKey namespacedKey) {
        return false;
    }

    @Override
    public int discoverRecipes(Collection<NamespacedKey> collection) {
        return 0;
    }

    @Override
    public boolean undiscoverRecipe(NamespacedKey namespacedKey) {
        return false;
    }

    @Override
    public int undiscoverRecipes(Collection<NamespacedKey> collection) {
        return 0;
    }

    @Override
    public Entity getShoulderEntityLeft() {
        return null;
    }

    @Override
    public void setShoulderEntityLeft(Entity entity) {

    }

    @Override
    public Entity getShoulderEntityRight() {
        return null;
    }

    @Override
    public void setShoulderEntityRight(Entity entity) {

    }

    @Override public GameMode getGameMode() { return GameMode.CREATIVE; }
    @Override public PlayerInventory getInventory() { return null; }
    @Override public ItemStack getItemInHand() { return null; }
    @Override public ItemStack getItemOnCursor() { return null; }
    @Override public String getName() { return name; }
    @Override public InventoryView getOpenInventory() { return null; } 
    @Override public int getSleepTicks() { return 0; }
    @Override public boolean isBlocking() { return false; }

    @Override
    public boolean isHandRaised() {
        return false;
    }

    @Override public boolean isSleeping() { return false; }
    @Override public InventoryView openEnchanting(Location arg0, boolean arg1) { return null; }
    @Override public InventoryView openInventory(Inventory arg0) { return null; }
    @Override public void openInventory(InventoryView arg0) { }

    @Override
    public InventoryView openMerchant(Villager villager, boolean b) {
        return null;
    }

    @Override
    public InventoryView openMerchant(Merchant merchant, boolean b) {
        return null;
    }

    @Override public InventoryView openWorkbench(Location arg0, boolean arg1) { return null; }
    @Override public void setGameMode(GameMode arg0) { }
    @Override public void setItemInHand(ItemStack arg0) { }
    @Override public void setItemOnCursor(ItemStack arg0) { }

    @Override
    public boolean hasCooldown(Material material) {
        return false;
    }

    @Override
    public int getCooldown(Material material) {
        return 0;
    }

    @Override
    public void setCooldown(Material material, int i) {

    }

    @Override public boolean setWindowProperty(Property arg0, int arg1) { return false; }
    @Override public boolean addPotionEffect(PotionEffect arg0) { return false; }
    @Override public boolean addPotionEffect(PotionEffect arg0, boolean arg1) { return false; }
    @Override public boolean addPotionEffects(Collection<PotionEffect> arg0) { return false; }
    @Override public Collection<PotionEffect> getActivePotionEffects() { return null; }
    @Override public boolean getCanPickupItems() { return false; }
    @Override public EntityEquipment getEquipment() { return null; }
    @Override public double getEyeHeight() { return y; }
    @Override public double getEyeHeight(boolean arg0) { return y; }
    @Override public Location getEyeLocation() { return new Location(world, x, y, z); }
    @Override public Player getKiller() { return null; }
    @Override public double getLastDamage() { return 0; }
    @Override public int getMaximumAir() { return 0; }
    @Override public int getMaximumNoDamageTicks() { return 0; }
    @Override public int getNoDamageTicks() { return 0; }
    @Override public int getRemainingAir() { return 0; }
    @Override public boolean getRemoveWhenFarAway() { return false; }
    @Override public boolean hasLineOfSight(Entity arg0) { return false; }
    @Override public boolean hasPotionEffect(PotionEffectType arg0) { return false; }

    @Override
    public PotionEffect getPotionEffect(PotionEffectType potionEffectType) {
        return null;
    }

    @Override public <T extends Projectile> T launchProjectile(Class<? extends T> arg0) { return null; }
    @Override public void removePotionEffect(PotionEffectType arg0) { }
    @Override public void setCanPickupItems(boolean arg0) { }
    @Override public void setMaximumAir(int arg0) { }
    @Override public void setMaximumNoDamageTicks(int arg0) { }
    @Override public void setNoDamageTicks(int arg0) { }
    @Override public void setRemainingAir(int arg0) { }
    @Override public void setRemoveWhenFarAway(boolean arg0) { }
    @Override public boolean eject() { return false; }
    @Override public int getEntityId() { return 0; }
    @Override public float getFallDistance() { return 0; }
    @Override public int getFireTicks() { return 0; }
    @Override public EntityDamageEvent getLastDamageCause() { return null; }
    @Override public Location getLocation() { return getEyeLocation(); }
    @Override public Location getLocation(Location arg0) { return getEyeLocation(); }
    @Override public int getMaxFireTicks() { return 0; }
    @Override public List<Entity> getNearbyEntities(double arg0, double arg1, double arg2) { return null; }
    @Override public Entity getPassenger() { return null; }
    @Override public Server getServer() { return server; }

    @Override
    public boolean isPersistent() {
        return false;
    }

    @Override
    public void setPersistent(boolean b) {

    }

    @Override public int getTicksLived() { return 0; }
    @Override public EntityType getType() { return EntityType.PLAYER; }
    @Override public UUID getUniqueId() { return uuid; }
    @Override public Entity getVehicle() { return null; }
    @Override public Vector getVelocity() { return null; }

    @Override
    public double getHeight() {
        return 0;
    }

    @Override
    public double getWidth() {
        return 0;
    }

    @Override public World getWorld() { return world; }
    @Override public boolean isDead() { return false; }
    @Override public boolean isEmpty() { return false; }
    @Override public boolean isInsideVehicle() { return false; }
    @Override public boolean isValid() { return true; }
    @Override public boolean leaveVehicle() { return false; }
    @Override public void playEffect(EntityEffect arg0) { }
    @Override public void remove() { }
    @Override public void setFallDistance(float arg0) { }
    @Override public void setFireTicks(int arg0) { }
    @Override public void setLastDamageCause(EntityDamageEvent arg0) { }
    @Override public boolean setPassenger(Entity arg0) { return false; }

    @Override
    public List<Entity> getPassengers() {
        return null;
    }

    @Override
    public boolean addPassenger(Entity entity) {
        return false;
    }

    @Override
    public boolean removePassenger(Entity entity) {
        return false;
    }

    @Override public void setTicksLived(int arg0) { }
    @Override public void setVelocity(Vector arg0) { }
    @Override public boolean teleport(Location arg0) {
    	this.x = arg0.getX();
    	this.y = arg0.getY();
    	this.z = arg0.getZ();
    	this.world = arg0.getWorld();
    	return true;
    }
    @Override public boolean teleport(Entity arg0) { return teleport(arg0.getLocation()); }
    @Override public boolean teleport(Location arg0, TeleportCause arg1) { return teleport(arg0); }
    @Override public boolean teleport(Entity arg0, TeleportCause arg1) { return teleport(arg0); }
    @Override public List<MetadataValue> getMetadata(String arg0) { return null; }
    @Override public boolean hasMetadata(String arg0) { return false; }
    @Override public void removeMetadata(String arg0, Plugin arg1) { }
    @Override public void setMetadata(String arg0, MetadataValue arg1) { }
    @Override public double getHealth() { return 0; }
    @Override public double getMaxHealth() { return 0; }
    @Override public void resetMaxHealth() { }
    @Override public PermissionAttachment addAttachment(Plugin arg0) { return null; }
    @Override public PermissionAttachment addAttachment(Plugin arg0, int arg1) { return null; }
    @Override public PermissionAttachment addAttachment(Plugin arg0, String arg1, boolean arg2) { return null; }
    @Override public PermissionAttachment addAttachment(Plugin arg0, String arg1, boolean arg2, int arg3) { return null; }
    @Override public Set<PermissionAttachmentInfo> getEffectivePermissions() { return null; }
    @Override public boolean hasPermission(String arg0) { return true; }
    @Override public boolean hasPermission(Permission arg0) { return true; }
    @Override public boolean isPermissionSet(String arg0) { return false; }
    @Override public boolean isPermissionSet(Permission arg0) { return false; }
    @Override public void recalculatePermissions() { }
    @Override public void removeAttachment(PermissionAttachment arg0) { }
    @Override public boolean isOp() { return true; }
    @Override public void setOp(boolean arg0) { }
    @Override public void abandonConversation(Conversation arg0) { }
    @Override public void abandonConversation(Conversation arg0, ConversationAbandonedEvent arg1) { }
    @Override public void acceptConversationInput(String arg0) { }
    @Override public boolean beginConversation(Conversation arg0) { return false; }
    @Override public boolean isConversing() { return false; }
    @Override public void sendMessage(String arg0) { } //System.out.println(name + ": " + arg0); }
    @Override public void sendMessage(String[] arg0) { }
    @Override public long getFirstPlayed() { return 0; }
    @Override public long getLastPlayed() { return 0; }
    @Override public Player getPlayer() { return this; }
    @Override public boolean hasPlayedBefore() { return true; }
    @Override public boolean isBanned() { return false; }
    @Override public boolean isOnline() { return true; }
    @Override public boolean isWhitelisted() { return true; }
    @Override public void setWhitelisted(boolean arg0) { }
    @Override public Map<String, Object> serialize() { return null; }
    @Override public Set<String> getListeningPluginChannels() { return null; }
    @Override public void sendPluginMessage(Plugin arg0, String arg1, byte[] arg2) { }
    @Override public void awardAchievement(Achievement arg0) { }
    @Override public boolean canSee(Player arg0) { return false; }
    @Override public void chat(String arg0) { }
    @Override public InetSocketAddress getAddress() { return null; }
    @Override public boolean getAllowFlight() { return true; }
    @Override public Location getBedSpawnLocation() { return null; }
    @Override public Location getCompassTarget() { return null; }
    @Override public String getDisplayName() { return name; }
    @Override public float getExhaustion() { return 0; }
    @Override public float getExp() { return 0; }
    @Override public float getFlySpeed() { return 0; }
    @Override public int getFoodLevel() { return 0; }
    @Override public int getLevel() { return 0; }
    @Override public String getPlayerListName() { return null; }
    @Override public long getPlayerTime() { return 0; }
    @Override public long getPlayerTimeOffset() { return 0; }
    @Override public float getSaturation() { return 0; }
    @Override public int getTotalExperience() { return 0; }
    @Override public float getWalkSpeed() { return 0; }
    @Override public void giveExp(int arg0) { }
    @Override public void giveExpLevels(int arg0) { }
    @Override public void hidePlayer(Player arg0) { }

    @Override
    public void hidePlayer(Plugin plugin, Player player) {

    }

    @Override public void incrementStatistic(Statistic arg0) { }
    @Override public void incrementStatistic(Statistic arg0, int arg1) { }
    @Override public void incrementStatistic(Statistic arg0, Material arg1) { }
    @Override public void incrementStatistic(Statistic arg0, Material arg1, int arg2) { }
    @Override public boolean isFlying() { return false; }
    @Override public boolean isPlayerTimeRelative() { return false; }
    @Override public boolean isSleepingIgnored() { return false; }
    @Override public boolean isSneaking() { return false; }
    @Override public boolean isSprinting() { return false; }
    @Override public void kickPlayer(String arg0) { }
    @Override public void loadData() { }
    @Override public boolean performCommand(String arg0) {
        server.getLogger().info("[CBWrapper] A dummy player is trying to run " + arg0);
        return false; }
    @Override @Deprecated public void playEffect(Location arg0, Effect arg1, int arg2) { }
    @Override public <T> void playEffect(Location arg0, Effect arg1, T arg2) { }
    @Override @Deprecated public void playNote(Location arg0, byte arg1, byte arg2) { }
    @Override public void playNote(Location arg0, Instrument arg1, Note arg2) { }
    @Override public void playSound(Location arg0, Sound arg1, float arg2, float arg3) { }
    @Override public void resetPlayerTime() { }
    @Override public void saveData() { }
    @Override @Deprecated public void sendBlockChange(Location arg0, Material arg1, byte arg2) { }

    @Override
    public void sendBlockChange(Location location, BlockData blockData) {

    }

    @Override @Deprecated public boolean sendChunkChange(Location arg0, int arg1, int arg2, int arg3, byte[] arg4) { return false; }
    @Override public void sendMap(MapView arg0) { }
    @Override public void sendRawMessage(String arg0) { }
    @Override public void setAllowFlight(boolean arg0) { }
    @Override public void setBedSpawnLocation(Location arg0) { }
    @Override public void setBedSpawnLocation(Location arg0, boolean arg1) { }
    @Override public void setCompassTarget(Location arg0) { }
    @Override public void setDisplayName(String arg0) { }
    @Override public void setExhaustion(float arg0) { }
    @Override public void setExp(float arg0) { }
    @Override public void setFlySpeed(float arg0) throws IllegalArgumentException { }
    @Override public void setFlying(boolean arg0) { }
    @Override public void setFoodLevel(int arg0) { }
    @Override public void setLevel(int arg0) { }
    @Override public void setPlayerListName(String arg0) { }

    @Override
    public String getPlayerListHeader() {
        return null;
    }

    @Override
    public String getPlayerListFooter() {
        return null;
    }

    @Override
    public void setPlayerListHeader(String s) {

    }

    @Override
    public void setPlayerListFooter(String s) {

    }

    @Override
    public void setPlayerListHeaderFooter(String s, String s1) {

    }

    @Override public void setPlayerTime(long arg0, boolean arg1) { }
    @Override public void setSaturation(float arg0) { }
    @Override public void setSleepingIgnored(boolean arg0) { }
    @Override public void setSneaking(boolean arg0) { }
    @Override public void setSprinting(boolean arg0) { }
    @Override public void setTexturePack(String arg0) { }
    @Override public void setTotalExperience(int arg0) { }
    @Override public void setWalkSpeed(float arg0) throws IllegalArgumentException { }
    @Override public void showPlayer(Player arg0) { }

    @Override
    public void showPlayer(Plugin plugin, Player player) {

    }

    @Override @Deprecated public void updateInventory() { }
    @Override public String getCustomName() { return null; }
    @Override public boolean isCustomNameVisible() { return false; }

    @Override
    public void setGlowing(boolean b) {

    }

    @Override
    public boolean isGlowing() {
        return false;
    }

    @Override
    public void setInvulnerable(boolean b) {

    }

    @Override
    public boolean isInvulnerable() {
        return false;
    }

    @Override
    public boolean isSilent() {
        return false;
    }

    @Override
    public void setSilent(boolean b) {

    }

    @Override
    public boolean hasGravity() {
        return false;
    }

    @Override
    public void setGravity(boolean b) {

    }

    @Override
    public int getPortalCooldown() {
        return 0;
    }

    @Override
    public void setPortalCooldown(int i) {

    }

    @Override
    public Set<String> getScoreboardTags() {
        return null;
    }

    @Override
    public boolean addScoreboardTag(String s) {
        return false;
    }

    @Override
    public boolean removeScoreboardTag(String s) {
        return false;
    }

    @Override
    public PistonMoveReaction getPistonMoveReaction() {
        return null;
    }

    @Override
    public BlockFace getFacing() {
        return null;
    }

    @Override public void setCustomName(String arg0) { }
    @Override public void setCustomNameVisible(boolean arg0) { }
    @Override public WeatherType getPlayerWeather() { return null; }
    @Override public Scoreboard getScoreboard() { return null; }
    @Override @Deprecated public boolean isOnGround() { return false; }
    @Override public void resetPlayerWeather() {  }
    @Override public void setPlayerWeather(WeatherType arg0) {  }
    @Override public void setScoreboard(Scoreboard arg0) throws IllegalArgumentException, IllegalStateException { }
    @Override public void setLastDamage(double arg0) {  }
    @Override public void damage(double arg0) {  }
    @Override public void damage(double arg0, Entity arg1) {  }
    @Override public void setHealth(double arg0) {  }
    @Override public void setMaxHealth(double arg0) {  }
    @Override public double getHealthScale() { return 0; }

    @Override
    public Entity getSpectatorTarget() {
        return null;
    }

    @Override
    public void setSpectatorTarget(Entity entity) {

    }

    @Override
    public void sendTitle(String s, String s1) {

    }

    @Override
    public void sendTitle(String s, String s1, int i, int i1, int i2) {

    }

    @Override
    public void resetTitle() {

    }

    @Override
    public void spawnParticle(Particle particle, Location location, int i) {

    }

    @Override
    public void spawnParticle(Particle particle, double v, double v1, double v2, int i) {

    }

    @Override
    public <T> void spawnParticle(Particle particle, Location location, int i, T t) {

    }

    @Override
    public <T> void spawnParticle(Particle particle, double v, double v1, double v2, int i, T t) {

    }

    @Override
    public void spawnParticle(Particle particle, Location location, int i, double v, double v1, double v2) {

    }

    @Override
    public void spawnParticle(Particle particle, double v, double v1, double v2, int i, double v3, double v4, double v5) {

    }

    @Override
    public <T> void spawnParticle(Particle particle, Location location, int i, double v, double v1, double v2, T t) {

    }

    @Override
    public <T> void spawnParticle(Particle particle, double v, double v1, double v2, int i, double v3, double v4, double v5, T t) {

    }

    @Override
    public void spawnParticle(Particle particle, Location location, int i, double v, double v1, double v2, double v3) {

    }

    @Override
    public void spawnParticle(Particle particle, double v, double v1, double v2, int i, double v3, double v4, double v5, double v6) {

    }

    @Override
    public <T> void spawnParticle(Particle particle, Location location, int i, double v, double v1, double v2, double v3, T t) {

    }

    @Override
    public <T> void spawnParticle(Particle particle, double v, double v1, double v2, int i, double v3, double v4, double v5, double v6, T t) {

    }

    @Override
    public AdvancementProgress getAdvancementProgress(Advancement advancement) {
        return null;
    }

    @Override
    public String getLocale() {
        return null;
    }

    @Override
    public void updateCommands() {

    }

    @Override
    public Spigot spigot() {
        return null;
    }

    @Override public void setHealthScale(double arg0) { }
    @Override public void setHealthScaled(boolean arg0) { }
    @Override public boolean isHealthScaled() { return false; }
    @Override @Deprecated public void playSound(Location arg0, String arg1, float arg2, float arg3) { }

    @Override
    public void playSound(Location location, Sound sound, SoundCategory soundCategory, float v, float v1) {

    }

    @Override
    public void playSound(Location location, String s, SoundCategory soundCategory, float v, float v1) {

    }

    @Override
    public void stopSound(Sound sound) {

    }

    @Override
    public void stopSound(String s) {

    }

    @Override
    public void stopSound(Sound sound, SoundCategory soundCategory) {

    }

    @Override
    public void stopSound(String s, SoundCategory soundCategory) {

    }

    @Override public boolean setLeashHolder(Entity arg0) { return false; }

    @Override
    public boolean isGliding() {
        return false;
    }

    @Override
    public void setGliding(boolean b) {

    }

    @Override
    public boolean isSwimming() {
        return false;
    }

    @Override
    public void setSwimming(boolean b) {

    }

    @Override
    public boolean isRiptiding() {
        return false;
    }

    @Override
    public void setAI(boolean b) {

    }

    @Override
    public boolean hasAI() {
        return false;
    }

    @Override
    public void setCollidable(boolean b) {

    }

    @Override
    public boolean isCollidable() {
        return false;
    }

    @Override public Entity getLeashHolder() { return null; }
    @Override public boolean isLeashed() { return false; }
    @Override public void setResourcePack(String arg0) { }

    @Override
    public void setResourcePack(String s, byte[] bytes) {

    }

    @Override public <T extends Projectile> T launchProjectile(Class<? extends T> arg0, Vector arg1) { return null;     }
    @Override public void decrementStatistic(Statistic arg0) throws IllegalArgumentException { }
    @Override public void decrementStatistic(Statistic arg0, int arg1) throws IllegalArgumentException { }
    @Override public void decrementStatistic(Statistic arg0, Material arg1) throws IllegalArgumentException { }
    @Override public void decrementStatistic(Statistic arg0, EntityType arg1) throws IllegalArgumentException { }
    @Override public void decrementStatistic(Statistic arg0, Material arg1, int arg2) throws IllegalArgumentException { }
    @Override public void decrementStatistic(Statistic arg0, EntityType arg1, int arg2) { }
    @Override public int getStatistic(Statistic arg0) throws IllegalArgumentException { return 0; }
    @Override public int getStatistic(Statistic arg0, Material arg1) throws IllegalArgumentException { return 0; }
    @Override public int getStatistic(Statistic arg0, EntityType arg1) throws IllegalArgumentException { return 0; }
    @Override public boolean hasAchievement(Achievement arg0) { return false; }
    @Override public void incrementStatistic(Statistic arg0, EntityType arg1) throws IllegalArgumentException { }
    @Override public void incrementStatistic(Statistic arg0, EntityType arg1, int arg2) throws IllegalArgumentException { }
    @Override public void removeAchievement(Achievement arg0) { }
    @Override public void setStatistic(Statistic arg0, int arg1) throws IllegalArgumentException { }
    @Override public void setStatistic(Statistic arg0, Material arg1, int arg2) throws IllegalArgumentException { }
    @Override public void setStatistic(Statistic arg0, EntityType arg1, int arg2) { }
    @Override public void sendSignChange(Location l, String[] str) {}
    @Override public List<Block> getLineOfSight(Set<Material> transparent, int maxDistance) {   return null; }
    @Override public Block getTargetBlock(Set<Material> transparent, int maxDistance) { return null; }
    @Override public List<Block> getLastTwoTargetBlocks(Set<Material> transparent, int maxDistance) { return null; }

    @Override
    public AttributeInstance getAttribute(Attribute attribute) {
        return null;
    }
}
