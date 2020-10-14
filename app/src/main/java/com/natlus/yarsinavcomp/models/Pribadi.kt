package com.natlus.yarsinavcomp.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Pribadi(
    var nama: String,
    var fakultas: String,
    var prodi: String,
    var status: String,
    var password: String,
    var alasan: String,
    var nik: String,
    var prestasi: String,
    var tempat: String,
    var tanggal: String,
    var jenisKelamin: String,
    var kewarganegaraan: String,
    var agama: String,
    var alamat: String,
    var rt: String,
    var rw: String,
    var kodePos: String,
    var provinsi: String,
    var kota: String,
    var phone: String,
    var email: String
) : Parcelable