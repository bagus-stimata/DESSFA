package com.erp.distribution.sfa.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.erp.distribution.sfa.dao.*
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

    ], version = 1, exportSchema = false
)
@TypeConverters(RoomDateConverters::class)
abstract class AppDatabase : RoomDatabase() {

    abstract fun cocktailDao(): CocktailDao

    /**
     * abstract
     * Mekanisme untuk mengkoneksikan antara Kelas Database dengan Kelas Dao
     */
//    abstract fun fUserDao(): FUserDao?
//    abstract fun fUserRolesDao(): FUserRolesDao?

    abstract fun fAreaDao(): FAreaDao?
    abstract fun fCompanyDao(): FCompanyDao?
    abstract fun fCustomerDao(): FCustomerDao?
    abstract fun fCustomerGroupDao(): FCustomerGroupDao?
    abstract fun fCustomerPicDao(): FCustomerPicDao?
    abstract fun fCustomerSalesmanDao(): FCustomerSalesmanDao?
    abstract fun fDistributionChannelDao(): FDistributionChannelDao?
    abstract fun fDivisionDao(): FDivisionDao?
    abstract fun fExpedisiDao(): FExpedisiDao?
    abstract fun fGiroDao(): FGiroDao?
    abstract fun fMaterialDao(): FMaterialDao?
    abstract fun fMaterialGroup1Dao(): FMaterialGroup1Dao?
    abstract fun fMaterialGroup2Dao(): FMaterialGroup2Dao?
    abstract fun fMaterialGroup3Dao(): FMaterialGroup3Dao?
    abstract fun fMaterialPicDao(): FMaterialPicDao?
    abstract fun fMaterialSalesBrandDao(): FMaterialSalesBrandDao?
    abstract fun fParamDiskonItemDao(): FParamDiskonItemDao?
    abstract fun fParamDiskonItemVendorDao(): FParamDiskonItemVendorDao?
    abstract fun fParamDiskonNotaDao(): FParamDiskonNotaDao?
    abstract fun fPromotionRulesdPaymentsDao(): FPromotionRulesdPaymentsDao?
    abstract fun fPromotionRulesdValidCustsDao(): FPromotionRulesdValidCustsDao?
    abstract fun fPromotionRulesdValidProductsDao(): FPromotionRulesdValidProductsDao?
    abstract fun fPromotionRuleshDao(): FPromotionRuleshDao?
    abstract fun fRegionDao(): FRegionDao?
    abstract fun fSalesmanDao(): FSalesmanDao?
    abstract fun fStockDao(): FStockDao?
    abstract fun fSubAreaDao(): FSubAreaDao?
    abstract fun ftApPaymentdDao(): FtApPaymentdDao?
    abstract fun ftApPaymenthDao(): FtApPaymenthDao?
    abstract fun ftArPaymentdDao(): FtArPaymentdDao?
    abstract fun ftArPaymenthDao(): FtArPaymenthDao?
    abstract fun fTaxDao(): FTaxDao?
    abstract fun ftOpnamedItemsDao(): FtOpnamedItemsDao?
    abstract fun ftOpnamehDao(): FtOpnamehDao?
    abstract fun ftPriceAltdItemsDao(): FtPriceAltdItemsDao?
    abstract fun ftPriceAlthDao(): FtPriceAlthDao?
    abstract fun ftPricedItemsDao(): FtPricedItemsDao?
    abstract fun ftPricehDao(): FtPricehDao?
    abstract fun ftPurchasedItemsDao(): FtPurchasedItemsDao?
    abstract fun ftPurchasehDao(): FtPurchasehDao?
    abstract fun ftSalesdItemsDao(): FtSalesdItemsDao?
    abstract fun ftSaleshDao(): FtSaleshDao?
    abstract fun ftStockTransferdItemsDao(): FtStockTransferdItemsDao?
    abstract fun ftStockTransferhDao(): FtStockTransferhDao?
    abstract fun fUangMukaDao(): FUangMukaDao?
    abstract fun fVendorDao(): FVendorDao?
    abstract fun fWarehouseDao(): FWarehouseDao?
    abstract fun sysvarDao(): SysvarDao?




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