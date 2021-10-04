
import 'package:flutter/material.dart';
import 'signup.dart';
import 'home.dart';

class LoginPage extends StatefulWidget {
  static String tag= 'login-page';

  @override
  _LoginPageState createState() => _LoginPageState();
}

class _LoginPageState extends State<LoginPage> {
  @override
  Widget build(BuildContext context) {
    final logo =Hero(tag: 'hero', child: CircleAvatar(
      backgroundColor: Colors.transparent,
      radius: 109.0,
      child:Image.asset('assets/armLogo.png'),
    ),

    );
    final email= TextFormField(
      keyboardType: TextInputType.emailAddress,
      autofocus: false,
      
      decoration:InputDecoration(
        hintText: 'Email',
        
        contentPadding: EdgeInsets.fromLTRB(30.0, 20.0, 30.0, 20.0),
        border:OutlineInputBorder(borderRadius: BorderRadius.circular(42.0))

      ),
    );
    final pass= TextFormField(
      autofocus: false,
      
      obscureText: true,
        decoration:InputDecoration(
        hintText: 'Password',
        contentPadding: EdgeInsets.fromLTRB(30.0, 20.0, 30.0, 20.0),
        border:OutlineInputBorder(borderRadius: BorderRadius.circular(42.0))


),
    );
    final loginBtn = Padding(
      padding: EdgeInsets.symmetric(vertical: 16.0),
      child: RaisedButton(
        shape: RoundedRectangleBorder(
          borderRadius: BorderRadius.circular(24),

        ),
        onPressed: (){
           Navigator.of(context).pushNamed(HomePage.tag);
        },
        padding: EdgeInsets.all(12),
        color: Colors.orange.shade100,
        child:Text('Log In',style:TextStyle(color:Colors.brown.shade900,fontSize: 36)),
      ),

    );
    final forgotlabel = RaisedButton(
      child: Text(
        'Create New Account',
        style:TextStyle(color: Colors.grey.shade900,fontSize: 24),
      ),
      onPressed: () {
        Navigator.push
        (
            context,
            MaterialPageRoute(builder: (context)
        {
          return new SignUp();
        })


);

      },
    );
    return Scaffold(
      backgroundColor: Colors.white,
      body: Center(
        child: ListView(
          shrinkWrap: true,
          padding: EdgeInsets.only(left: 24.0,right: 24.0),
          children:<Widget>[
            logo,
            SizedBox(height: 50.0),
            email,
            SizedBox(height: 15.0),
            pass,
            SizedBox(height: 24.0),
            loginBtn,
            forgotlabel


          ],
        ),
      ),
    );

  }
}
