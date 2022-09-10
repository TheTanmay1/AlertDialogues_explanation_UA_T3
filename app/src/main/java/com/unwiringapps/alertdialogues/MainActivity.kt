package com.unwiringapps.alertdialogues

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
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
                 builder.setMessage("Enter a color")
                 builder.setTitle("Background Color")


                  builder.setPositiveButton("Save"){ dialog, _ ->
              Toast.makeText(this, "Thanks for Saving",Toast.LENGTH_SHORT ).show()
                  }

                 builder.setNegativeButton("Cancel"){ dialog, _ ->
                     Toast.makeText(this, "Ohh You Canceled me",Toast.LENGTH_SHORT ).show()
                 }

                 val dialog = builder.create()
                 dialog.show()

             }


    }
}