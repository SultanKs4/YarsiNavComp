package com.natlus.yarsinavcomp.view

import android.app.DatePickerDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.natlus.yarsinavcomp.R
import com.natlus.yarsinavcomp.databinding.FragmentSelfBinding
import com.natlus.yarsinavcomp.models.Pribadi
import java.util.*

class SelfFragment : Fragment() {
    private lateinit var binding: FragmentSelfBinding

    private lateinit var dataFakultas: Array<String>
    private lateinit var dataProdi: Array<String>
    private lateinit var dataStatus: Array<String>
    private lateinit var dataAgama: Array<String>
    private lateinit var dataProvinsi: Array<String>
    private lateinit var dataKota: Array<String>
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_self, container, false)
        setUp()
        loadDataSpinner()

        binding.editTextDate.setOnClickListener {
            datePicker()
        }

        binding.btnSelftoParent.setOnClickListener {
            moveToParent()
        }
        return binding.root
    }

    private fun setUp() {
        dataFakultas = resources.getStringArray(R.array.dataFakultas)
        dataProdi = resources.getStringArray(R.array.dataProdi)
        dataStatus = resources.getStringArray(R.array.dataStatus)
        dataAgama = resources.getStringArray(R.array.dataAgama)
        dataProvinsi = resources.getStringArray(R.array.dataProvinsi)
        dataKota = resources.getStringArray(R.array.dataKota)
    }

    private fun loadDataSpinner() {
        val adapterFakultas =
            ArrayAdapter(this.requireActivity(), android.R.layout.simple_spinner_item, dataFakultas)
        val adapterProdi =
            ArrayAdapter(this.requireActivity(), android.R.layout.simple_spinner_item, dataProdi)
        val adapterStatus =
            ArrayAdapter(this.requireActivity(), android.R.layout.simple_spinner_item, dataStatus)
        val adapterAgama =
            ArrayAdapter(this.requireActivity(), android.R.layout.simple_spinner_item, dataAgama)
        val adapterProvinsi =
            ArrayAdapter(this.requireActivity(), android.R.layout.simple_spinner_item, dataProvinsi)
        val adapterKota =
            ArrayAdapter(this.requireActivity(), android.R.layout.simple_spinner_item, dataKota)

        adapterFakultas.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        adapterProdi.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        adapterStatus.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        adapterAgama.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        adapterProvinsi.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        adapterKota.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        binding.spinnerFakultas.adapter = adapterFakultas
        binding.spinnerProdi.adapter = adapterProdi
        binding.spinnerStatus.adapter = adapterStatus
        binding.spinnerAgama.adapter = adapterAgama
        binding.spinnerProvinsi.adapter = adapterProvinsi
        binding.spinnerKota.adapter = adapterKota
    }

    private fun datePicker() {
        val cal = Calendar.getInstance()
        val year = cal.get(Calendar.YEAR)
        val month = cal.get(Calendar.MONTH)
        val day = cal.get(Calendar.DAY_OF_MONTH)


        val dpd = DatePickerDialog(
            this.requireContext(),
            { _, year, monthOfYear, dayOfMonth ->
                val bulan = (monthOfYear + 1)
                binding.editTextDate.setText("$dayOfMonth/$bulan/$year")
            },
            year,
            month,
            day
        )
        dpd.show()
    }

    private fun radioButtonSelectionSex(): String {
        val selected: Int = binding.radioGroupSex.checkedRadioButtonId
        return if (selected == binding.radioButtonPerempuan.id) {
            binding.radioButtonPerempuan.text.toString()
        } else {
            binding.radioButtonLaki.text.toString()
        }
    }

    private fun radioButtonSelectionNation(): String {
        val selected: Int = binding.radioGroupNationality.checkedRadioButtonId
        return if (selected == binding.radioButtonAsing.id) {
            binding.radioButtonAsing.text.toString()
        } else {
            binding.radioButtonIndonesia.text.toString()
        }
    }

    private fun moveToParent() {
        val dataPribadi = Pribadi(
            nama = binding.editTextNama.text.toString(),
            fakultas = binding.spinnerFakultas.selectedItem.toString(),
            prodi = binding.spinnerProdi.selectedItem.toString(),
            status = binding.spinnerStatus.selectedItem.toString(),
            password = binding.editTextPassword.text.toString(),
            alasan = binding.editTextAlasan.text.toString(),
            nik = binding.editTextNik.text.toString(),
            prestasi = binding.editTextPrestasi.text.toString(),
            tempat = binding.editTextPlace.text.toString(),
            tanggal = binding.editTextDate.text.toString(),
            jenisKelamin = radioButtonSelectionSex(),
            kewarganegaraan = radioButtonSelectionNation(),
            agama = binding.spinnerAgama.selectedItem.toString(),
            alamat = binding.editTextAlamat.text.toString(),
            rt = binding.editTextRT.text.toString(),
            rw = binding.editTextRW.text.toString(),
            kodePos = binding.editTextPostal.text.toString(),
            provinsi = binding.spinnerProvinsi.selectedItem.toString(),
            kota = binding.spinnerKota.selectedItem.toString(),
            phone = binding.editTextPhone.text.toString(),
            email = binding.editTextEmail.text.toString()
        )
        val action =
            SelfFragmentDirections.actionSelfFragmentToParentFragment(pribadi = dataPribadi)
        findNavController().navigate(action)
    }
}