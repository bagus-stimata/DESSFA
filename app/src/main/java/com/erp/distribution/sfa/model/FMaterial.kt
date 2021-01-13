package com.erp.distribution.sfa.model

import androidx.room.Entity
import androidx.room.Ignore
import org.codehaus.jackson.annotate.JsonIgnore
import java.io.Serializable
import java.util.*

@Entity(tableName = "fMaterial")
class FMaterial : Serializable {
    @PrimaryKey(autoGenerate = true)
    var id = 0

    /*
    * JIKA COPY DARI TEMPAT LAIN: MAKA SEBAGAI LOG TRACK MENINGGALKAN SOURCE_ID = ID sumber asal dia dicopy
    * keperluan diantaranya:
    * 1. Clone Database. karena tidak mungkin menggunakan Kode External yang bisa jadi kemungkinan kembar, tapi harus pakai kode internal
    * 2. 
    */
    @Ignore
    @JsonIgnore
    var sourceID = 0

    @Ignore
    @JsonIgnore
    var noUrut = 0
    var pcode = ""
    var barcode = ""
    var pname = ""

    @Ignore
    @JsonIgnore
    var oldKode1 = ""

    @Ignore
    @JsonIgnore
    var varianName = ""

    @Ignore
    @JsonIgnore
    var isFreeGood = false

    @Ignore
    @JsonIgnore
    var shortname = ""
    var isStatusActive = true

    /*
    * KLASIFIKASI: BASIC
    */
    /* 
	 * exclusiveDivisionTransaction: Input Penjualan dan Pembelian akan menolak jika item product berlainan Divisi
	 * Transaksi Mutasi & Stock opname tidak termasuk(sementara)
	 * jika Division = All Division maka exclusiveDivisionView tidak berlaku
	 * 
	 * exclusiveDivisionView: hanya akan dapat dilihat dan dipergunakan untuk transaksi untuk User dengan Divisi Sama
	 * 
	 * 	 Dalam satu Divisi biasanya terdapat beberapa Vendor
	 */
    @Ignore
    @JsonIgnore
    var isExclusiveDivisionTransaction = false

    @Ignore
    @JsonIgnore
    var isExclusiveDivisionView = false

    //	@ManyToOne
    //	@JoinColumn(name="fdivisionBean", referencedColumnName="ID")
    //	private FDivision fdivisionBean;
    var fdivisionBean = 0

    /*
    * TAX
    */
    //	@ManyToOne
    //	@JoinColumn(name="ftaxBean", referencedColumnName="ID")
    //	private FTax ftaxBean;
    var ftaxBean = 0

    @Ignore
    @JsonIgnore
    var isTaxable = true

    /*
    * Adalah Vendor Utama Produk Tersebut
    * Kenyataanya Material/Product didapatkan dari banyak Vendor/Suplier
    * 
    * exclusiveVendorTransaction: Input Penjualan, Pembelian akan menolak jika berlaikan Vendor
    * Transaksi Mutasi & Stock opname tidak termasuk(sementara)
    */
    @Ignore
    @JsonIgnore
    var isExclusiveVendorTransaction = false

    //	@ManyToOne
    //	@JoinColumn(name="fvendorBean", referencedColumnName="ID")
    //	private FVendor fvendorBean;
    var fvendorBean = 0

    //	@ManyToOne
    //	@JoinColumn(name="fwarehouseBean_Utm", referencedColumnName="ID")
    //	private FWarehouse fwarehouseBean_Utm;
    @Ignore
    @JsonIgnore
    var fwarehouseBean_Utm = 0

    @Ignore
    @JsonIgnore
    var materialType: EnumMaterialType? = null

    //	@ManyToOne
    //	@JoinColumn(name="fdistributionChannelBean", referencedColumnName="ID")
    //	private FDistributionChannel fdistributionChannelBean;
    @Ignore
    @JsonIgnore
    var fdistributionChannelBean = 0

    //	@ManyToOne
    //	@JoinColumn(name="fmaterialGroup3Bean", referencedColumnName="ID")
    //	private FMaterialGroup3 fmaterialGroup3Bean;
    var fmaterialGroup3Bean = 0

    /*
    * KLASIFIKASI: SALES
    */
    //	@ManyToOne
    //	@JoinColumn(name="fmaterialSalesBrandBean", referencedColumnName="ID")
    //	private FMaterialSalesBrand fmaterialSalesBrandBean;
    var fmaterialSalesBrandBean = 0

    //BATCH CODE --> Berhubungan dengan Stockist atau Gudang
    //PRODUCTION CODE --> Berhubungan dengan TANGGAL DIPRODUKSI DAN EXP.DATE
    @Ignore
    @JsonIgnore
    var principalCode = ""

    @Ignore
    @JsonIgnore
    var batchCode = ""

    @Ignore
    @JsonIgnore
    var productionCode = ""
    var productionDate = Date()
    var expiredDate = Date()

    @Ignore
    @JsonIgnore
    var prodclass = 0
    var uom1 = ""
    var uom2 = ""
    var uom3 = ""
    var uom4 = ""
    var convfact1 = 1 //uom1 to uom4
    var convfact2 = 1 //uom2 to uom4
    var convfact3 = 1 //uom3 to uom4

    /*
    * PRICE yang muncul pada faktur dengan menggunakan UOM
    * 0. dan 1 adalah default
    * 2. uom 2
    * 3. uom 3
    * 4.uom 4
    * 
    */
    var priceUom: EnumUom = EnumUom.UOM1

    //	@Transient
    //	private Integer temp_QtySaldo = 0; //Penolong untuk keperluan lain: seperti untuk saldo retur atas faktur
    @Ignore
    var temp_QtySaldo = 0.0 //Penolong untuk keperluan lain: seperti untuk saldo retur atas faktur

    /*
    * Harga Beli berbeda dengan HPP
    */
    @Ignore
    @JsonIgnore
    var hargaBeliUOM4NetAfterPpn = 0.0

    /*
    * HPP disimpan Perdivisi pada Tabel AccBalanceHpp
    * HPP adalah Harga Net Per Barang SEBELUM PPN
    */
    @Ignore
    @JsonIgnore
    var hppAwalPprice2 = 0.0 //Jika tidak ada HPP Awal maka menggunakan Harga Barang Net Sebelum PPN

    @Ignore
    @JsonIgnore
    var hppLifo = 0.0

    @Ignore
    @JsonIgnore
    var hppLifoTotalAmount = 0.0

    @Ignore
    @JsonIgnore
    var hppAverage = 0.0

    @Ignore
    @JsonIgnore
    var hppAverageTotalAmount = 0.0

    @Ignore
    @JsonIgnore
    var hppFifo = 0.0

    @Ignore
    @JsonIgnore
    var hppFifoTotalAmount = 0.0

    //PPRICE:: Disimpan dalam satuan Terbesar dan Terkecil. Setelah dan sebelum PPN
    var pprice = 0.0
    var ppriceAfterPpn = 0.0
    var pprice2 = 0.0
    var pprice2AfterPpn = 0.0
    var sprice = 0.0
    var spriceAfterPpn: Double? = null
    var sprice2 = 0.0
    var sprice2AfterPpn = 0.0

    /*
    * Min Stok: sama dengan Buffer Stock
    * Max Stock: Stok dikatakan Over, sebetulnya tidak terlalu kepake, karena
    * cara yang paling realistis untuk mengukur stok over adalah
    * Melihat History Penjualan Vs Jumalh Stok hasilnya adalah = Jumlah hari stok akan habis
    */
    var minQtyStok = 0

    //TIDAK BOLEH DIGANTI-GANTI
    @Ignore
    @JsonIgnore //dalam Mili Liter
    var volumeSmalest = 0

    //Dalam Grams
    var weightSmalest = 0

    //Dalam Grams
    var caseWeight = 0

    //IN Cm.. Cm3
    @Ignore
    @JsonIgnore
    var caseWidth = 0 //Panjang

    @Ignore
    @JsonIgnore
    var caseHeight = 0 //Tinggi

    @Ignore
    @JsonIgnore
    var caseDepth = 0 //Lebar (dibalik kan kalau english.. hehehe)

    @Ignore
    @JsonIgnore
    var isFlagNewItem = false

    @Ignore
    @JsonIgnore
    var isFlagNewPrice = false

    @Ignore
    @JsonIgnore
    var isUseSpriceAlt = false

    //#PRICEALT1 -- Retail -->ALL AFTER PPN
    //Retail-Besar
    @Ignore
    @JsonIgnore
    var spriceAltRetailBes = 0.0

    //Retail-Sedang
    @Ignore
    @JsonIgnore
    var spriceAltRetailSed = 0.0

    //Retail-Kecil
    @Ignore
    @JsonIgnore
    var spriceAltRetailKec = 0.0

    //#PRICEALT2 --> Grosir 1
    //Grosir-Besar
    @Ignore
    @JsonIgnore
    var spriceAltGrosir1Bes = 0.0

    //Grosir-Sed
    @Ignore
    @JsonIgnore
    var spriceAltGrosir1Sed = 0.0

    //Grosir-Kec
    @Ignore
    @JsonIgnore
    var spriceAltGrosir1Kec = 0.0

    //#PRICEALT3 --> Grosir 2
    //Grosir2-Bes
    //Grosir-Besar
    @Ignore
    @JsonIgnore
    var spriceAltGrosir2Bes = 0.0

    //Grosir-Sed
    @Ignore
    @JsonIgnore
    var spriceAltGrosir2Sed = 0.0

    //Grosir-Kec
    @Ignore
    @JsonIgnore
    var spriceAltGrosir2Kec = 0.0

    //Grosir Quantity
    @Ignore
    @JsonIgnore
    var spriceAltGrosirQtyMoreEqual1 = 0.0

    @Ignore
    @JsonIgnore
    var spriceAltGrosirQtyMoreEqual2 = 0.0

    @Ignore
    @JsonIgnore
    var spriceAltGrosirQtyMoreEqual3 = 0.0

    @Ignore
    @JsonIgnore
    var spriceAltGrosirQtyMoreEqual4 = 0.0

    @Ignore
    @JsonIgnore
    var spriceAltGrosirQtyValue1 = 0.0

    @JsonIgnore
    var spriceAltGrosirQtyValue2 = 0.0

    @Ignore
    @JsonIgnore
    var spriceAltGrosirQtyValue3 = 0.0

    @Ignore
    @JsonIgnore
    var spriceAltGrosirQtyValue4 = 0.0

    @JsonIgnore
    var created = Date()

    @JsonIgnore
    var modified = Date()

    @JsonIgnore
    var modifiedBy = "" //User ID

    @Ignore
    @JsonIgnore
    var isStared = false

    @Ignore
    @JsonIgnore
    var isUnread = false

    @Ignore
    @JsonIgnore
    var isSelected = false
    override fun equals(o: Any?): Boolean {
        if (this === o) return true
        if (o == null || javaClass != o.javaClass) return false
        val fMaterial = o as FMaterial
        return id == fMaterial.id
    }

    override fun hashCode(): Int {
        return id.hashCode()
    }

    override fun toString(): String {
        return "FMaterial{" +
                "id=" + id +
                '}'
    }
}