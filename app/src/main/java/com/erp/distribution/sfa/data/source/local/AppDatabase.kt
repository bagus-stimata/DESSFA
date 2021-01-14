package com.erp.distribution.sfa.data.source.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.erp.distribution.sfa.data.source.local.dao.CocktailDao
import com.erp.distribution.sfa.data.source.local.entity.CocktailEntity
import com.erp.distribution.sfa.data.source.local.entity.FavoritesEntity
import com.erp.distribution.sfa.model.*
import com.erp.distribution.sfa.model.FCustomerPic
import com.erp.distribution.sfa.model.FCustomerSalesman
import com.erp.distribution.sfa.model.FParamDiskonItem
import com.erp.distribution.sfa.model.FParamDiskonItemVendor
import com.erp.distribution.sfa.model.FParamDiskonNota
import com.erp.distribution.sfa.model.FtSalesh
import com.erp.distribution.sfa.model.Sysvar
import com.erp.distribution.sfa.model.utils.RoomDateConverters
import com.erp.distribution.sfa.security_model.FUser
import com.erp.distribution.sfa.security_model.FUserRoles


@Database(
    entities = [
        FavoritesEntity::class,
        CocktailEntity::class,
        FUser::class, FUserRoles::class,
        FArea::class, FCompany::class, FCustomer::class, FCustomerGroup::class, FCustomerPic::class, FCustomerSalesman::class,
        FDistributionChannel::class, FDivision::class, FGiro::class, FMaterial::class, FMaterialGroup1::class,
        FMaterialGroup2::class, FMaterialGroup3::class, FMaterialPic::class, FMaterialSalesBrand::class,
        FParamDiskonItem::class, FParamDiskonItemVendor::class, FParamDiskonNota::class, FPromotionRulesdPayments::class,
        FPromotionRulesdValidCusts::class, FPromotionRulesdValidProducts::class, FPromotionRulesh::class,
        FRegion::class, FSalesman::class, FStock::class, FSubArea::class, FtApPaymentd::class, FtApPaymenth::class,
        FtArPaymentd::class, FtArPaymenth::class, FTax::class, FtOpnamedItems::class, FtOpnameh::class,
        FtPriceAltdItems::class, FtPriceAlth::class, FtPricedItems::class, FtPriceh::class, FtPurchasedItems::class, FtPurchaseh::class,
        FtSalesdItems::class, FtSalesh::class, FtStockTransferdItems::class, FtStockTransferh::class, FUangMuka::class,
        FVendor::class, FWarehouse::class, Sysvar::class, FExpedisi::class

], version = 1, exportSchema = false)
@TypeConverters(RoomDateConverters::class)
abstract class AppDatabase : RoomDatabase() {

    abstract fun cocktailDao(): CocktailDao

    companion object {
        @Volatile private var instance: AppDatabase? = null

        fun getDatabase(context: Context, dbName: String): AppDatabase =
            instance ?: synchronized(this) { instance ?: buildDatabase(context, dbName).also { instance = it } }

        private fun buildDatabase(appContext: Context, dbName: String) =
            Room.databaseBuilder(appContext, AppDatabase::class.java, dbName)
                .fallbackToDestructiveMigration()
                .build()
    }

}