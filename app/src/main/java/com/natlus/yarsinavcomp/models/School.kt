package com.natlus.yarsinavcomp.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class School(
    var namaUnivAsal: String,
    var namaFakultasAsal: String,
    var namaProdiAsal: String,
    var provinsiUnivAsal: String,
    var kotaUnivAsal: String,
    var alamatUnivAsal: String,
    var kodePosUnivAsal: String,
    var akreditasiUnivAsal: String,
    var nilaiIPK: String
) : Parcelable