package tfcwailaplugin

import cpw.mods.fml.common.FMLLog
import mcp.mobius.waila.api.IWailaRegistrar

import com.bioxx.tfc.TileEntities.{TEBarrel, TEWorldItem, TECrop}

object Providers {

  def init(registrar: IWailaRegistrar): Unit = {
    FMLLog.info("CropProvider")
    registrar.registerStackProvider(CropProvider, classOf[TECrop])

    FMLLog.info("WorldItemProvider")
    registrar.registerStackProvider(WorldItemProvider, classOf[TEWorldItem])

    FMLLog.info("BarrelProvider")
    registrar.registerBodyProvider(BarrelProvider, classOf[TEBarrel])

  }

}
