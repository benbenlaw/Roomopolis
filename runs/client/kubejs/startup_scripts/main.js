const $ItemProperties = Java.loadClass("net.minecraft.world.item.Item$Properties");
const $keyItem = Java.loadClass('com.benbenlaw.roomopolis.item.KeyItem')

StartupEvents.registry('item', event => {
    //New Standard Key ($ItemProperties, structure id, height offset, keyblock id)
    event.createCustom("custom_key_block", () => new $keyItem(new $ItemProperties(), "roomopolis:tiny_room", 0, "minecraft:gold_block"));
    //Easy build key (default item properties) (structure id, height offset)
    event.createCustom("easy_build", () => new $keyItem("roomopolis:tiny_room", 0));
    //No Key Block  ($ItemProperties, structure id, height offset)
    event.createCustom("no_property", () => new $keyItem(new $ItemProperties(), "roomopolis:tiny_room", 0));
})
