Contents from: 

http://www.jondev.net/articles/Sending_Emails_without_User_Intervention_(no_Intents)_in_Android
https://www.youtube.com/watch?v=UNPFWCNMJPU

Developing Time: 2 hr

Level: 1/3

Testing Devices: Emulator and Galaxy 4S

Testing: Successful

Learned: 

1. auth = "true"; this has to be String not boolean in Mail class
2. less secure apps has to be enabled in google security settings. https://www.google.com/settings/security/lesssecureapps
3. Components libraries: additionnal.jar, mail.jar, activation.jar
4. Add  "<uses-permission android:name="android.permission.INTERNET" />" in AndroidManifest

 
![demo](https://cloud.githubusercontent.com/assets/11301947/10007304/02c8696a-6079-11e5-9f80-e3335848c5a3.png)

![demo1](https://cloud.githubusercontent.com/assets/11301947/10007468/6525338a-607a-11e5-9c97-a4e4c09f4a7c.png)



