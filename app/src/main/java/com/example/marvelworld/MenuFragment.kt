package com.example.marvelworld

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup


class MenuFragment : Fragment() {

    private var name: String? = null
    private var adress: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            name = it.getString(NAME_BUNDLE)
            adress = it.getString(ADRESS_BUNDLE)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_menu, container, false)
    }

    companion object {
        const val NAME_BUNDLE = "name"
        const val ADRESS_BUNDLE = "adress"

        @JvmStatic
        fun newInstance(name: String, adress: String) =
            MenuFragment().apply {
                arguments = Bundle().apply {
                    putString(NAME_BUNDLE, name)
                    putString(ADRESS_BUNDLE, adress)
                }
            }
    }
}