package com.natlus.yarsinavcomp.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.natlus.yarsinavcomp.R
import com.natlus.yarsinavcomp.databinding.FragmentParentBinding
import com.natlus.yarsinavcomp.models.Parent

class ParentFragment : Fragment() {
    private lateinit var binding: FragmentParentBinding
    private val args: ParentFragmentArgs by navArgs()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_parent, container, false)

        binding.btnParenttoSchool.setOnClickListener {
            moveToSchool()
        }

        return binding.root
    }

    private fun moveToSchool() {
        val dataParent = Parent(
            namaAyah = binding.editTextNamaAyah.text.toString(),
            nikAyah = binding.editTextNikAyah.text.toString(),
            namaIbu = binding.editTextNamaIbu.text.toString(),
            nikIbu = binding.editTextNikIbu.text.toString(),
            tanggalLahirAyah = binding.editTextLahirAyah.text.toString(),
            tanggalLahirIbu = binding.editTextLahirIbu.text.toString(),
            alamatParent = binding.editTextAlamat.text.toString(),
            phoneOrtu = binding.editTextPhone.text.toString(),
            emailParent = binding.editTextEmail.text.toString(),
            pendidikanAyah = binding.editTextPendidikanAyah.text.toString(),
            pendidikanIbu = binding.editTextPendidikanIbu.text.toString(),
            pekerjaanAyah = binding.editTextPekerjaanAyah.text.toString(),
            pekerjaanIbu = binding.editTextPekerjaanIbu.text.toString(),
        )

        val action =
            ParentFragmentDirections.actionParentFragmentToSchoolFragment(
                pribadi = args.pribadi,
                parent = dataParent
            )
        findNavController().navigate(action)
    }
}