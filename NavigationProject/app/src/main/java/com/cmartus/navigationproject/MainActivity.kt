package com.cmartus.navigationproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.cmartus.navigationproject.ui.main.MainFragment
import android.net.Uri

class MainActivity : AppCompatActivity(), secondFragment.OnFragmentInteractionListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)

    }

    override fun onFragmentInteraction(uri: Uri){

    }
}