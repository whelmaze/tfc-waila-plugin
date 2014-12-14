package tfcwailaplugin

import com.bioxx.tfc.Food.{CropIndexPepper, CropIndex, CropManager}
import com.bioxx.tfc.TileEntities.TECrop
import mcp.mobius.waila.api.{IWailaConfigHandler, IWailaDataAccessor}
import net.minecraft.item.ItemStack


object CropProvider extends ProviderBase[TECrop] {

  override def getWailaStack(accessor: IWailaDataAccessor, config: IWailaConfigHandler): ItemStack =
    // Cropそれ自体じゃなくて収穫後のアイテムを表示してるのでどうにかしたい
    accessor.getTileEntity match {
      case e: TECrop =>
        CropManager.getInstance.getCropFromId(e.cropId) match {
          case pepper: CropIndexPepper => pepper.getOutput2(e)
          case others: CropIndex => others.getOutput1(e)
          case _ => null
        }
      case _ => null
    }

}