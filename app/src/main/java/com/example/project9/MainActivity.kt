package com.example.project9

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.project9.databinding.ActivityMainBinding
import com.example.project9.local_db.entity.User
import com.example.project9.view_model.MyViewModel
import com.google.android.material.snackbar.Snackbar
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity(), UserAdapter.OnUserClickListener {

    private lateinit var binding: ActivityMainBinding
    private val viewModel: MyViewModel by viewModels()
    private lateinit var adapter: UserAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.apply {
            viewModel.apply {
                adapter = UserAdapter(this@MainActivity)
                rvUser.adapter = adapter
                rvUser.layoutManager = LinearLayoutManager(this@MainActivity)

                btnInsert.setOnClickListener{
                    insertUserToDB(
                        User(
                            name = edtName.text.toString(),
                            email = edtEmail.text.toString(),
                            phoneNumber = edtPhone.text.toString()
                        )
                    )
                }

                users.observe(this@MainActivity, {
                    adapter.populateData(it)
                })
            }
        }
    }

    override fun onUserClicked(user: User) {
        viewModel.apply {
            val placeholder = user
            deleteUserFromDB(user)
            Snackbar.make(
                binding.root,
                "Successfully delete user with name ${user.name}",
            Snackbar.LENGTH_LONG
            ).apply {
                setAction("Undo") {
                    insertUserToDB(placeholder)
                }
                show()
            }
        }
    }
}