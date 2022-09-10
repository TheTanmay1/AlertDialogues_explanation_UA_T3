package com.unwiringapps.alertdialogues

import android.app.Dialog
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.unwiringapps.alertdialogues.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.defaultAlertbtn.setOnClickListener {

            val builder = AlertDialog.Builder(this)
            builder.setMessage("Red, Blue, or Yellow ..?")
            builder.setTitle("What background color do you want ?")

            val color = EditText(this)
            builder.setView(color)



            builder.setPositiveButton("Save") { dialog, _ ->
//              Toast.makeText(this, "Thanks for Saving",Toast.LENGTH_SHORT ).show()

                if (color.text.toString() == "red") {
                    binding.mainLayout1.setBackgroundColor(Color.RED)
                } else if (color.text.toString() == "blue") {
                    binding.mainLayout1.setBackgroundColor(Color.BLUE)
                } else if (color.text.toString() == "yellow")
                    binding.mainLayout1.setBackgroundColor(Color.YELLOW)
            }

            builder.setNegativeButton("Cancel") { dialog, _ ->
                Toast.makeText(this, "Ohh You Canceled me", Toast.LENGTH_SHORT).show()
            }

            builder.setNeutralButton("Hadd hai") { dialog, _ ->

                binding.mainLayout1.setBackgroundColor(Color.WHITE)

                Toast.makeText(this, "Hadd hai yaar", Toast.LENGTH_SHORT).show()
            }

            val dialog = builder.create()
            dialog.show()

        }



        binding.customAlertbtn.setOnClickListener {
            val customDialog = Dialog(this)
            customDialog.setContentView(R.layout.custom_dialog_layout)
            customDialog.show()


            val button1 = customDialog.findViewById<View>(R.id.button1)
            val button2 = customDialog.findViewById<View>(R.id.button2)
            val button3 = customDialog.findViewById<View>(R.id.button3)
            val button4 = customDialog.findViewById<View>(R.id.button4)
            val edittext1 = customDialog.findViewById<EditText>(R.id.edittext1)

            button1.setOnClickListener {
                binding.mainLayout1.setBackgroundColor(Color.RED)
                Toast.makeText(this, "Called by button1", Toast.LENGTH_SHORT).show()
                customDialog.dismiss()
            }
            button2.setOnClickListener {
                Toast.makeText(this, "Called by button2", Toast.LENGTH_SHORT).show()
                binding.mainLayout1.setBackgroundColor(Color.BLUE)
                customDialog.dismiss()
            }
            button3.setOnClickListener {
                binding.mainLayout1.setBackgroundColor(Color.YELLOW)
                Toast.makeText(this, "Called by button3", Toast.LENGTH_SHORT).show()
                customDialog.dismiss()
            }



            button4.setOnClickListener {

                val tt1 = edittext1.text.toString()
                if (tt1 == "red")

                {
                    binding.mainLayout1.setBackgroundColor(Color.RED)

                }

                else if (tt1 == "blue")

                {
                    binding.mainLayout1.setBackgroundColor(Color.BLUE)
                }

                else if (tt1 == "yellow")

                {
                    binding.mainLayout1.setBackgroundColor(Color.YELLOW)
                }

                Toast.makeText(this, "Called by button4", Toast.LENGTH_SHORT).show()
                customDialog.dismiss()
            }
        }


    }

}
