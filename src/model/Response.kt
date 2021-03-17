package com.covidapp.model

import com.covidapp.model.News


data class Response(
    val success_status: Boolean? = true,
   // var tarih: String? = null,
    val gunluk_test: String? = null,
    val gunluk_vaka: String? = null,
    val gunluk_hasta: String? = null,
    val gunluk_vefat: String? = null,
    val gunluk_iyilesen: String? = null,
    val toplam_test: String? = null,
    val toplam_hasta: String? = null,
    val toplam_vefat: String? = null,
    val toplam_iyilesen: String? = null,
    //var toplam_yogun_bakim: String? = null,
    //var toplam_entube: String? = null,
    //var hastalarda_zaturre_oran: String? = null,
    val agir_hasta_sayisi: String? = null,
   /* var yatak_doluluk_orani: String? = null,
    var eriskin_yogun_bakim_doluluk_orani: String? = null,
    var ventilator_doluluk_orani: String? = null,
    var ortalama_filyasyon_suresi: String? = null,
    var ortalama_temasli_tespit_suresi: String? = null,
    var filyasyon_orani: String? = null*/
    var haberler: List<News>? = null
)