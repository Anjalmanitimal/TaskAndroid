package com.example.task1

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class RegisterActivity : AppCompatActivity() {

    // Declare UI components
    private lateinit var etName: EditText
    private lateinit var etEmail: EditText
    private lateinit var etPassword: EditText
    private lateinit var rgGender: RadioGroup
    private lateinit var spinnerCountry: Spinner
    private lateinit var etSearchCity: EditText
    private lateinit var cbAgree: CheckBox
    private lateinit var btnSubmit: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        // Initialize UI components
        etName = findViewById(R.id.etName)
        etEmail = findViewById(R.id.etEmail)
        etPassword = findViewById(R.id.etPassword)
        rgGender = findViewById(R.id.rgGender)
        spinnerCountry = findViewById(R.id.spinnerCountry)
        etSearchCity = findViewById(R.id.etSearchCity)
        cbAgree = findViewById(R.id.cbAgree)
        btnSubmit = findViewById(R.id.btnSubmit)


        val countryList = arrayOf("Item 1", "Item 2", "Item 3", "Item 4")
        val spinnerAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, countryList)
        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinnerCountry.adapter = spinnerAdapter

        btnSubmit.setOnClickListener {

            val name = etName.text.toString()
            val email = etEmail.text.toString()
            val password = etPassword.text.toString()
            val genderId = rgGender.checkedRadioButtonId
            val selectedGender = if (genderId != -1) findViewById<RadioButton>(genderId).text else "Not Selected"
            val country = spinnerCountry.selectedItem.toString()
            val city = etSearchCity.text.toString()
            val agreed = cbAgree.isChecked


            if (name.isEmpty() || email.isEmpty() || password.isEmpty() || !agreed) {
                Toast.makeText(this, "Please fill all fields and accept terms.", Toast.LENGTH_SHORT).show()
            } else {

                val languages = arrayListOf(
                    "Item 0", "Item 1", "Item 2", "Item 3", "Item 4",
                    "Item 5", "Item 6", "Item 7", "Item 8", "Item 9"
                )

                // Pass data to DisplayActivity
                val intent = Intent(this, DisplayActivity::class.java)
                intent.putExtra("NAME", name)
                intent.putExtra("EMAIL", email)
                intent.putExtra("GENDER", selectedGender.toString())
                intent.putExtra("COUNTRY", country)
                intent.putExtra("CITY", city)
                intent.putStringArrayListExtra("LANGUAGES", languages)
                startActivity(intent)
            }
        }
    }
}