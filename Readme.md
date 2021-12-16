This project has been created for Final Project.
This project has email authentication with the help of firebase.
This project uses firestore to save data.

There is a bug in the project. The register button in "LoginActivity" needs an intent to redirect to "RegisterActivity".
To resolve this issue:

In "LoginActivity.kt", there is a onclick listener for register button.
in there add the intent as follows:

```Kotlin
binding.registerButton.setOnClickListener {
            val intent = Intent(this,RegisterActivity::class.java)
            startActivity(intent)
        }
```
