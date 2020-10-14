package com.natlus.yarsinavcomp.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.natlus.yarsinavcomp.R
import com.natlus.yarsinavcomp.databinding.FragmentSchoolBinding
import com.natlus.yarsinavcomp.models.School

class SchoolFragment : Fragment() {
    private lateinit var binding: FragmentSchoolBinding
    private val args: SchoolFragmentArgs by navArgs()

    private lateinit var dataProvinsi: Array<String>
    private lateinit var dataKota: Array<String>
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_school, container, false)

        setUp()
        loadDataSpinner()

        binding.btnGoToResult.setOnClickListener {
            intentToResult()
        }

        return binding.root
    }

    private fun setUp() {
        dataProvinsi = resources.getStringArray(R.array.dataProvinsi)
        dataKota = resources.getStringArray(R.array.dataKota)
    }

    private fun loadDataSpinner() {
        val adapterProvinsi =
            ArrayAdapter(this.requireActivity(), android.R.layout.simple_spinner_item, dataProvinsi)
        val adapterKota =
            ArrayAdapter(this.requireActivity(), android.R.layout.simple_spinner_item, dataKota)

        adapterProvinsi.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        adapterKota.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        binding.spinnerProvinsiUnivAsal.adapter = adapterProvinsi
        binding.spinnerKotaUnivAsal.adapter = adapterKota
    }

    private fun intentToResult() {
        val dataSchool = School(
            namaUnivAsal = binding.editTextUnivAsal.text.toString(),
            namaFakultasAsal = binding.editTextFakultasAsal.text.toString(),
            namaProdiAsal = binding.editTextProdiAsal.text.toString(),
            provinsiUnivAsal = binding.spinnerProvinsiUnivAsal.selectedItem.toString(),
            kotaUnivAsal = binding.spinnerKotaUnivAsal.selectedItem.toString(),
            alamatUnivAsal = binding.editTextAlamatUnivAsal.text.toString(),
            kodePosUnivAsal = binding.editTextKodePos.text.toString(),
            akreditasiUnivAsal = binding.editTextAkreditasiUnivAsal.text.toString(),
            nilaiIPK = binding.editTextNilaiIPK.text.toString(),
        )
        val action =
            SchoolFragmentDirections.actionSchoolFragmentToResultFragment(
                parent = args.parent,
                pribadi = args.pribadi,
                school = dataSchool
            )
        findNavController().navigate(action)
    }
}