package uz.amirdev.pdfviewer.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import uz.amirdev.pdfviewer.R
import uz.amirdev.pdfviewer.adapters.RVAdapter
import uz.amirdev.pdfviewer.databinding.FragmentSecondBinding
import uz.amirdev.pdfviewer.models.ItemModel
import uz.amirdev.pdfviewer.utils.MySharedPreferences

class SecondFragment : Fragment() {

    lateinit var binding: FragmentSecondBinding
    private lateinit var itemList: ArrayList<ItemModel>
    private lateinit var lecturesList: ArrayList<ItemModel>
    private lateinit var laboratoriesList: ArrayList<ItemModel>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSecondBinding.inflate(inflater)
        MySharedPreferences.init(binding.root.context)
        itemList = ArrayList()
        lecturesList = ArrayList()
        laboratoriesList = ArrayList()
        loadLaboratoriesList()
        loadLecturesList()
        setRecyclerViewItems()
        binding.backIcon.setOnClickListener {
            parentFragmentManager.popBackStack()
        }
        return binding.root
    }

    private fun setRecyclerViewItems() {
        when (MySharedPreferences.getMainItemPosition()) {
            0 -> itemList = lecturesList
            1 -> itemList = laboratoriesList
        }
        binding.recyclerView.adapter = RVAdapter(itemList, object : RVAdapter.OnItemClickListener {
            override fun onClick(item: ItemModel, position: Int) {
                onItemClick(position)
            }
        })
        binding.recyclerView.layoutManager = GridLayoutManager(binding.root.context, 2)
    }

    private fun onItemClick(position: Int) {
        MySharedPreferences.setItemPosition(position)
        parentFragmentManager.beginTransaction()
            .addToBackStack(null)
            .replace(R.id.fragmentContainerView, InfoFragment())
            .commit()
    }

    private fun loadLecturesList() {
        lecturesList.add(ItemModel("1-ma'ruza", R.drawable.ic_book))
        lecturesList.add(ItemModel("2-ma'ruza", R.drawable.ic_book))
        lecturesList.add(ItemModel("3-ma'ruza", R.drawable.ic_book))
        lecturesList.add(ItemModel("4-ma'ruza", R.drawable.ic_book))
        lecturesList.add(ItemModel("5-ma'ruza", R.drawable.ic_book))
        lecturesList.add(ItemModel("6-ma'ruza", R.drawable.ic_book))
        lecturesList.add(ItemModel("7-ma'ruza", R.drawable.ic_book))
        lecturesList.add(ItemModel("8-ma'ruza", R.drawable.ic_book))
        lecturesList.add(ItemModel("9-ma'ruza", R.drawable.ic_book))
        lecturesList.add(ItemModel("10-ma'ruza", R.drawable.ic_book))
        lecturesList.add(ItemModel("11-ma'ruza", R.drawable.ic_book))
        lecturesList.add(ItemModel("12-ma'ruza", R.drawable.ic_book))
        lecturesList.add(ItemModel("13-ma'ruza", R.drawable.ic_book))
        lecturesList.add(ItemModel("14-ma'ruza", R.drawable.ic_book))
    }

    private fun loadLaboratoriesList() {
        laboratoriesList.add(ItemModel("1-laboratoriya", R.drawable.ic_practice))
        laboratoriesList.add(ItemModel("2-laboratoriya", R.drawable.ic_practice))
        laboratoriesList.add(ItemModel("3-laboratoriya", R.drawable.ic_practice))
        laboratoriesList.add(ItemModel("4-laboratoriya", R.drawable.ic_practice))
        laboratoriesList.add(ItemModel("5-laboratoriya", R.drawable.ic_practice))
        laboratoriesList.add(ItemModel("6-laboratoriya", R.drawable.ic_practice))
        laboratoriesList.add(ItemModel("7-laboratoriya", R.drawable.ic_practice))
        laboratoriesList.add(ItemModel("8-laboratoriya", R.drawable.ic_practice))
        laboratoriesList.add(ItemModel("9-laboratoriya", R.drawable.ic_practice))
        laboratoriesList.add(ItemModel("10-laboratoriya", R.drawable.ic_practice))
        laboratoriesList.add(ItemModel("11-laboratoriya", R.drawable.ic_practice))
        laboratoriesList.add(ItemModel("12-laboratoriya", R.drawable.ic_practice))
        laboratoriesList.add(ItemModel("13-laboratoriya", R.drawable.ic_practice))
        laboratoriesList.add(ItemModel("14-laboratoriya", R.drawable.ic_practice))
    }
}