package uz.amirdev.pdfviewer.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import uz.amirdev.pdfviewer.R
import uz.amirdev.pdfviewer.databinding.ActivityMainBinding
import uz.amirdev.pdfviewer.fragments.MainFragment

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportFragmentManager.beginTransaction()
            .replace(R.id.fragmentContainerView, MainFragment()).commit()
    }

}