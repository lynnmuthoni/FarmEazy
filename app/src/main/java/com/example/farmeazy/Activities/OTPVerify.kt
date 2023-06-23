package com.example.farmeazy.Activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.farmeazy.R
import com.google.firebase.FirebaseException
import com.google.firebase.auth.PhoneAuthCredential
import com.google.firebase.auth.PhoneAuthProvider

class OTPVerify : AppCompatActivity() {
    private lateinit var callbacks: PhoneAuthProvider.OnVerificationStateChangedCallbacks
    var buttonOTPVerify: Button?=null
    var editTextOTP: EditText?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_otpverify)

        callbacks = object : PhoneAuthProvider.OnVerificationStateChangedCallbacks() {
            override fun onVerificationCompleted(credential: PhoneAuthCredential) {
                // Verification completed automatically (e.g., auto-retrieval of OTP)
                // You can proceed with signing up the user
                signUpWithPhoneCredential(credential)
            }

            override fun onVerificationFailed(e: FirebaseException) {
                // Verification failed
                // Handle the error case (e.g., display an error message to the user)
                Toast.makeText(this@SignUpActivity, "Verification Failed: ${e.message}", Toast.LENGTH_SHORT).show()
            }

            override fun onCodeSent(verificationId: String, token: PhoneAuthProvider.ForceResendingToken) {
                // Code has been sent to the user's phone
                // Save the verification ID and show the OTP entry UI to the user
                // You can save the verificationId and token in class fields to use later
                val mVerificationId = verificationId
                val mResendToken = token

                // Proceed with showing the OTP entry UI to the user
                showOtpEntryUi()
            }

        editTextOTP=findViewById(R.id.mEdtOTP)
        buttonOTPVerify=findViewById(R.id.BtnOTPVerify)
    }
        private fun signUpWithPhoneCredential(credential: PhoneAuthCredential) {
            auth.createUserWithCredential(credential)
                .addOnCompleteListener(this) { task ->
                    if (task.isSuccessful) {
                        // User sign-up successful
                        val user = auth.currentUser
                        // Proceed with your desired actions (e.g., navigate to the main screen)
                    } else {
                        // User sign-up failed
                        // Handle the error case (e.g., display an error message to the user)
                        Toast.makeText(this@SignUpActivity, "Sign Up Failed", Toast.LENGTH_SHORT).show()
                    }
                }
        }

        private fun showOtpEntryUi() {
            // Show the OTP entry UI to the user
            // You can start a new activity or update the current UI to show an OTP entry field
        }
    }
}