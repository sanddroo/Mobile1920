package com.github.sandddrooo

import android.content.Context
import android.content.LocusId
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.ViewParent
import android.view.inputmethod.InputMethodManager
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import com.github.sandddrooo.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*
import java.text.FieldPosition

class MainActivity : AppCompatActivity(){

    private lateinit var binding: ActivityMainBinding

    private val myData : MyData = MyData("Created By Sandro Tampan")

    private val  loremIpsum: Ipsum = Ipsum("Lorem Ipsum","Lorem ipsum dolor sit amet,consectetur adipiscing elit.\n" +
            "            \\nAliquam eget commodo risus, in maximus est.\n" +
            "            \\nMorbi ac lectus velit.\n" +
            "            \\nMorbi gravida viverra ante sed venenatis.\n" +
            "            \\nSed ac est tristique, malesuada quam id, maximus sem.\n" +
            "            \\nPellentesque malesuada ante non velit ultrices, ac porta diam tempor.\n" +
            "            \\nMorbi eu metus sit amet justo tincidunt ultrices.\n" +
            "            \\nCras tincidunt mollis rhoncus.\n" +
            "            \\nNunc rutrum nisl vitae velit ullamcorper commodo vitae et metus.\n" +
            "            \\nQuisque scelerisque facilisis augue, in blandit ligula vehicula gravida.\n" +
            "            \\nAliquam non venenatis odio, ac molestie nunc.\n" +
            "            \\nPhasellus venenatis, magna sed congue facilisis, mauris erat porta dui, et lacinia massa tellus ut enim.\n" +
            "            \\nNulla facilisi.\n" +
            "            \\nInteger pellentesque nunc lobortis sapien accumsan hendrerit.\n" +
            "            \\nDonec aliquam, ex ut volutpat fringilla, ante nisl egestas nulla, non dictum enim purus ut nunc.")

    private val cupcakeIpsum: Ipsum = Ipsum("Cupcake Ipsum","Pie pastry donut sesame snaps brownie apple pie.\n" +
            " Candy canes dragée powder marzipan caramels jujubes tootsie roll marzipan.\n" +
            " Sweet roll gummi bears marzipan cake. Jelly gingerbread pastry. Jelly-o toffee cake sweet danish cake soufflé.\n" +
            " Topping chupa chups sweet roll chocolate bar cookie cake danish. Sweet roll cookie chocolate bar sesame snaps gingerbread.\n" +
            " Sweet roll topping dessert. Pastry topping donut. Chocolate bar sweet roll sesame snaps oat cake dessert.\n" +
            "Soufflé soufflé wafer cotton candy cake. Gummies cookie muffin toffee.")

    private val tunaIpsum: Ipsum = Ipsum("Tuna Ipsum","Tonguefish Japanese eel roughy seatrout chub Atlantic saury king of herring, tench Pacific viperfish luderick, blue triggerfish.\n" +
            " Bigeye, Blobfish buffalofish, Rio Grande perch. Tenpounder amago pirarucu largenose fish grunt sculpin dhufish European perch; sailfish, largenose fish.\n" +
            " Largemouth bass grideye piranha, angler catfish, freshwater hatchetfish luminous hake ghost fish cuskfish: threespine stickleback Antarctic cod.\n" +
            " X-ray tetra barb barbeled dragonfish handfish vimba pricklefish swordtail Australian grayling sailback scorpionfish yellow-and-black triplefin, clingfish halfbeak.\n" +
            " Stingfish coffinfish zebra lionfish false moray: ocean perch deepwater cardinalfish orbicular velvetfish.")

    private val baconIpsum: Ipsum = Ipsum("Bacon Ipsum","Bacon ipsum dolor amet tongue turkey salami ham ribeye doner. Filet mignon shank brisket, ham swine cupim meatball buffalo drumstick venison flank.\n" +
            " Pork beef shank prosciutto landjaeger tail. Chicken ground round flank ball tip prosciutto.")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.myData = myData
        binding.loremIpsum = loremIpsum
        binding.cupcakeIpsum = cupcakeIpsum
        binding.tunaIpsum = tunaIpsum
        binding.baconIpsum = baconIpsum

        val adapter = ArrayAdapter.createFromResource(this,
            R.array.ipsum_type ,android.R.layout.simple_spinner_item)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        binding.spinnerLorem.adapter = adapter

        binding.spinnerLorem.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{

            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                val currentType: String = binding.spinnerLorem.getItemAtPosition(position).toString()
                when(currentType){
                    "Lorem Ipsum" ->{
                        binding.titleText.text =loremIpsum.type
                        binding.loremText.text =loremIpsum.content
                    }
                    "Cupcake Ipsum"->{
                        binding.titleText.text =cupcakeIpsum.type
                        binding.loremText.text =cupcakeIpsum.content
                    }
                    "Tuna Ipsum"->{
                        binding.titleText.text = tunaIpsum.type
                        binding.loremText.text = tunaIpsum.content
                    }
                    "Bacon Ipsum"->{
                        binding.titleText.text = baconIpsum.type
                        binding.loremText.text = baconIpsum.content
                    }
                }
            }
            override fun onNothingSelected(parent: AdapterView<*>?) {
                Log.d("LoremGenerator :: ","onNothingSelected() is Called! Doing Nothing")
            }
        }
        binding.creatorButton.setOnClickListener {
            pickCreatorName(it)
        }
        binding.creatorText.setOnClickListener {
            changeCreatorName(it)
        }
    }
     private fun pickCreatorName(view: View){
         // assign views

         binding.apply {
             myData?.creator=creatorFill.text.toString()
             invalidateAll()
             creatorText.text = creatorFill.text.toString()
             creatorFill.visibility=View.GONE
             creatorButton.visibility=View.GONE
             creatorText.visibility=View.GONE
         }

         val imn = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
         imn.hideSoftInputFromWindow(view.windowToken,0)
     }

    private fun changeCreatorName(view: View){
        //assign view
        binding.apply {
            creatorFill.visibility=View.GONE
            creatorButton.visibility=View.GONE
            creatorText.visibility=View.GONE
            creatorFill.requestFocus()
        }

        val imn = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imn.showSoftInput(binding.creatorFill, 0)
    }
}
