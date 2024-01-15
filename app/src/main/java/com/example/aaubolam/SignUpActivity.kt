package com.example.aaubolam

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.aaubolam.databinding.ActivitySignUpBinding
import com.google.firebase.auth.FirebaseAuth

class SignUpActivity : AppCompatActivity() {
    val binding by lazy {
        ActivitySignUpBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.btnSignUp.setOnClickListener(){
            if (binding.name.editText?.text.toString().equals("")or
                binding.email.editText?.text.toString().equals("")or
                binding.password.editText?.text.toString().equals("")
                    ){
                Toast.makeText(this@SignUpActivity,"Please enter the all information",Toast.LENGTH_SHORT).show()
            }else{
                FirebaseAuth.getInstance().createUserWithEmailAndPassword(
                    binding.name.editText?.text.toString().trim(),
                    binding.password.editText?.text.toString().trim()
                ).addOnCompleteListener {
                    result->

                    if (result.isSuccessful){
                        Toast.makeText(this@SignUpActivity,"LogIn Successful",Toast.LENGTH_SHORT).show()
                    }else{
                        Toast.makeText(this@SignUpActivity,result.exception?.localizedMessage,Toast.LENGTH_SHORT).show()
                    }
                }

            }
        }
    }
}