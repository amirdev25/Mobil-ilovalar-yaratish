package uz.amirdev.pdfviewer.fragments

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import uz.amirdev.pdfviewer.R
import uz.amirdev.pdfviewer.adapters.RVAdapter
import uz.amirdev.pdfviewer.databinding.FragmentMainBinding
import uz.amirdev.pdfviewer.models.ItemModel
import uz.amirdev.pdfviewer.utils.MySharedPreferences

class MainFragment : Fragment() {

    lateinit var binding: FragmentMainBinding
    lateinit var itemList: ArrayList<ItemModel>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMainBinding.inflate(inflater)
        MySharedPreferences.init(binding.root.context)
        itemList = ArrayList()
        loadItemList()

        binding.recyclerView.adapter = RVAdapter(itemList, object : RVAdapter.OnItemClickListener {
            override fun onClick(item: ItemModel, position: Int) {
                when (position) {
                    in 0..1 -> {
                        MySharedPreferences.setMainItemPosition(position)
                        parentFragmentManager.beginTransaction()
                            .addToBackStack(null)
                            .replace(R.id.fragmentContainerView, SecondFragment())
                            .commit()
                    }
                    2 -> {
                        MySharedPreferences.setMainItemPosition(position)
                        parentFragmentManager.beginTransaction()
                            .addToBackStack(null)
                            .replace(R.id.fragmentContainerView, InfoFragment())
                            .commit()
                    }
                    3 -> {
                        startActivity(Intent(Intent.ACTION_VIEW, Uri.parse("https://medium.com/@sanjar_suvonov")))
                    }
                    4 -> {
                        startActivity(
                            Intent(
                                Intent.ACTION_VIEW,
                                Uri.parse("https://www.youtube.com/c/Dasturchilar")
                            )
                        )
                    }
                    5 -> {
                        MySharedPreferences.setMainItemPosition(position)
                        parentFragmentManager.beginTransaction()
                            .addToBackStack(null)
                            .replace(R.id.fragmentContainerView, InfoFragment())
                            .commit()
                    }
                }
            }
        })
        binding.recyclerView.layoutManager = GridLayoutManager(binding.root.context, 2)
        return binding.root
    }

    private fun loadItemList() {
        itemList.add(ItemModel("Ma'ruza", R.drawable.ic_lecture))
        itemList.add(ItemModel("Labaratoriya", R.drawable.ic_lab))
        itemList.add(ItemModel("Testlar", R.drawable.ic_quiz))
        itemList.add(ItemModel("Qiziqarli ma'lumotlar", R.drawable.ic_facts))
        itemList.add(ItemModel("Video", R.drawable.ic_video))
        itemList.add(ItemModel("Ilova haqida", R.drawable.ic_info))
    }

}