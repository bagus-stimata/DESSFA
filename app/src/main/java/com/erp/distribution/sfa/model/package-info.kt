/**
 *
 */
/**
 * @author yhawin
 */
package com.erp.distribution.sfa.model

import com.erp.distribution.sfa.model.modelenum.Enum3Level
import com.erp.distribution.sfa.model.modelenum.EnumAccCoaType
import com.erp.distribution.sfa.model.modelenum.EnumAccTransactionType
import com.erp.distribution.sfa.model.modelenum.EnumCurrency
import com.erp.distribution.sfa.model.modelenum.EnumFormatFaktur
import com.erp.distribution.sfa.model.modelenum.EnumJenisNomorUrut
import com.erp.distribution.sfa.model.modelenum.EnumKeyGoogleAPI
import com.erp.distribution.sfa.model.modelenum.EnumLunasBelum
import com.erp.distribution.sfa.model.modelenum.EnumMaterialType
import com.erp.distribution.sfa.model.modelenum.EnumMaxRowsShow
import com.erp.distribution.sfa.model.modelenum.EnumMonth
import com.erp.distribution.sfa.model.modelenum.EnumOrganizationLevel
import com.erp.distribution.sfa.model.modelenum.EnumPromoDiscFgMethod
import com.erp.distribution.sfa.model.modelenum.EnumReligion
import com.erp.distribution.sfa.model.modelenum.EnumRequestStatus
import com.erp.distribution.sfa.model.modelenum.EnumSalesType
import com.erp.distribution.sfa.model.modelenum.EnumStatusGiro
import com.erp.distribution.sfa.model.modelenum.EnumStatusOperasiForm
import com.erp.distribution.sfa.model.modelenum.EnumStatusPengiriman
import com.erp.distribution.sfa.model.modelenum.EnumStatusProteksi
import com.erp.distribution.sfa.model.modelenum.EnumStatusService
import com.erp.distribution.sfa.model.modelenum.EnumStatusUpload
import com.erp.distribution.sfa.model.modelenum.EnumTipeFakturBeli
import com.erp.distribution.sfa.model.modelenum.EnumTipeFakturJual
import com.erp.distribution.sfa.model.modelenum.EnumTipeImporFromFile
import com.erp.distribution.sfa.model.modelenum.EnumTipeJob
import com.erp.distribution.sfa.model.modelenum.EnumTipePajakCustomer
import com.erp.distribution.sfa.model.modelenum.EnumTipeSettlement
import com.erp.distribution.sfa.model.modelenum.EnumTipeStockOpname
import com.erp.distribution.sfa.model.modelenum.EnumTipeStockTransfer
import com.erp.distribution.sfa.model.modelenum.EnumTipeSuratJalan
import com.erp.distribution.sfa.model.modelenum.EnumTipeUserDetil
import com.erp.distribution.sfa.model.modelenum.EnumTipeWarehouse
import com.erp.distribution.sfa.model.modelenum.EnumTunaiKredit
import com.erp.distribution.sfa.model.modelenum.EnumUom
import com.erp.distribution.sfa.model.modelenum.EnumUserOtorizeType
import androidx.room.PrimaryKey
import com.erp.distribution.sfa.model.FArea
import com.erp.distribution.sfa.model.Sysvar
import com.erp.distribution.sfa.model.FCustomer
import com.erp.distribution.sfa.model.FtSalesdItems
import com.erp.distribution.sfa.model.FtSalesh
import com.erp.distribution.sfa.model.FMaterial
import com.erp.distribution.sfa.model.transient_model.KeyIntDate
import com.erp.distribution.sfa.model.transient_model.KeyLongDate
import com.erp.distribution.sfa.model.transient_model.ZLapTemplate1
import com.erp.distribution.sfa.model.transient_model.ZLapTemplate2
import com.erp.distribution.sfa.model.transient_model.ZLapMutasiStock
import com.erp.distribution.sfa.model.transient_model.ZLapPackingList
import com.erp.distribution.sfa.model.transient_model.ZLapPrestasiKerja
import com.erp.distribution.sfa.model.transient_model.ZLapAktifitasPromoList
import com.erp.distribution.sfa.model.FCustomerPic
import com.erp.distribution.sfa.model.FParamDiskonItem
import com.erp.distribution.sfa.model.FParamDiskonNota
import com.erp.distribution.sfa.model.FCustomerSalesman
import com.erp.distribution.sfa.model.FtJobdItems
import com.erp.distribution.sfa.model.FParamDiskonItemVendor
