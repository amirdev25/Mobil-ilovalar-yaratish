package uz.amirdev.pdfviewer.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import uz.amirdev.pdfviewer.R
import uz.amirdev.pdfviewer.databinding.FragmentInfoBinding
import uz.amirdev.pdfviewer.utils.MySharedPreferences

class InfoFragment : Fragment() {

    lateinit var binding: FragmentInfoBinding
    private val labList = arrayOf(
        "laboratoriya_ishi_1.pdf",
        "laboratoriya_ishi_2.pdf",
        "laboratoriya_ishi_3.pdf",
        "laboratoriya_ishi_4.pdf",
        "laboratoriya_ishi_5.pdf",
        "laboratoriya_ishi_6.pdf",
        "laboratoriya_ishi_7.pdf",
        "laboratoriya_ishi_8.pdf",
        "laboratoriya_ishi_9.pdf",
        "laboratoriya_ishi_10.pdf",
        "laboratoriya_ishi_11.pdf",
        "laboratoriya_ishi_12.pdf",
        "laboratoriya_ishi_13.pdf",
        "laboratoriya_ishi_14.pdf",
    )
    private val labTitle = arrayOf(
        "1-laboratoriya ishi",
        "2-laboratoriya ishi",
        "3-laboratoriya ishi",
        "4-laboratoriya ishi",
        "5-laboratoriya ishi",
        "6-laboratoriya ishi",
        "7-laboratoriya ishi",
        "8-laboratoriya ishi",
        "9-laboratoriya ishi",
        "10-laboratoriya ishi",
        "11-laboratoriya ishi",
        "12-laboratoriya ishi",
        "13-laboratoriya ishi",
        "14-laboratoriya ishi",
    )
    private val lecturesTitle = arrayOf(
        "1-Ma'ruza",
        "2-Ma'ruza",
        "3-Ma'ruza",
        "4-Ma'ruza",
        "5-Ma'ruza",
        "6-Ma'ruza",
        "7-Ma'ruza",
        "8-Ma'ruza",
        "9-Ma'ruza",
        "10-Ma'ruza",
        "11-Ma'ruza",
        "12-Ma'ruza",
        "13-Ma'ruza",
        "14-Ma'ruza",
    )

    private val lecturesList = arrayOf(
        "mavzu_1.pdf",
        "mavzu_2.pdf",
        "mavzu_3.pdf",
        "mavzu_4.pdf",
        "mavzu_5.pdf",
        "mavzu_6.pdf",
        "mavzu_7.pdf",
        "mavzu_8.pdf",
        "mavzu_9.pdf",
        "mavzu_10.pdf",
        "mavzu_11.pdf",
        "mavzu_12.pdf",
        "mavzu_13.pdf",
        "mavzu_14.pdf",
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentInfoBinding.inflate(inflater)
        MySharedPreferences.init(binding.root.context)
        binding.backIcon.setOnClickListener {
            parentFragmentManager.popBackStack()
        }
        val mainItemPosition = MySharedPreferences.getMainItemPosition()
        val itemPosition = MySharedPreferences.getItemPosition()
        when (mainItemPosition) {
            0 -> {
                hideInformation()
                binding.pdfView.fromAsset(lecturesList[itemPosition]).show()
                binding.titleText.text = lecturesTitle[itemPosition]
            }
            1 -> {
                hideInformation()
                binding.pdfView.fromAsset(labList[itemPosition]).show()
                binding.titleText.text = labTitle[itemPosition]
            }
            2 -> {
                hideInformation()
                binding.pdfView.fromAsset("test.pdf").show()
                binding.titleText.text = getText(R.string.quizes)
            }
            5 -> {
                showInformation()
            }
        }

        return binding.root
    }

    private fun showInformation() {
        binding.aboutConstraintLayout.visibility = View.VISIBLE
        binding.pdfView.visibility = View.GONE
    }

    private fun hideInformation() {
        binding.aboutConstraintLayout.visibility = View.GONE
        binding.pdfView.visibility = View.VISIBLE
    }

}