package com.natlus.yarsinavcomp.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Parent(
    var namaAyah: String,
    var nikAyah: String,
    var namaIbu: String,
    var nikIbu: String,
    var tanggalLahirAyah: String,
    var tanggalLahirIbu: String,
    var alamatParent: String,
    var phoneOrtu: String,
    var emailParent: String,
    var pendidikanAyah: String,
    var pendidikanIbu: String,
    var pekerjaanAyah: String,
    var pekerjaanIbu: String
) : Parcelable