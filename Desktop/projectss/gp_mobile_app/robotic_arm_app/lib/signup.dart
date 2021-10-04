import 'package:flutter/material.dart';
import 'login_page.dart';
class SignUp extends StatefulWidget {
  static String tag='signup-page';

  @override
  _SignUpState createState() => _SignUpState();
}

class _SignUpState extends State<SignUp> {
  @override
  Widget build(BuildContext context) {
    final logo =Hero(tag: 'hero', child: CircleAvatar(
      backgroundColor: Colors.transparent,
      radius: 100.0,
      child:Image.asset('assets/armLogo.png',),
    ),

    );
    final username= TextFormField(
      keyboardType: TextInputType.text,
      autofocus: false,
      decoration:InputDecoration(
          hintText: 'Username',
          contentPadding: EdgeInsets.fromLTRB(20.0, 10.0, 20.0, 20.0),
          border:OutlineInputBorder(borderRadius: BorderRadius.circular(32.0))

      ),
    );
    final email= TextFormField(
      keyboardType: TextInputType.emailAddress,
      autofocus: false,

      decoration:InputDecoration(
          hintText: 'Email',
          contentPadding: EdgeInsets.fromLTRB(20.0, 10.0, 20.0, 20.0),
          border:OutlineInputBorder(borderRadius: BorderRadius.circular(32.0))

      ),
    );
    final pass= TextFormField(
      autofocus: false,

      obscureText: true,
      decoration:InputDecoration(
          hintText: 'Password',
          contentPadding: EdgeInsets.fromLTRB(20.0, 10.0, 20.0, 20.0),
          border:OutlineInputBorder(borderRadius: BorderRadius.circular(32.0))


      ),
    );
    final sign_up_btn = Padding(
      padding: EdgeInsets.symmetric(vertical: 16.0),
      child: RaisedButton(
        shape: RoundedRectangleBorder(
          borderRadius: BorderRadius.circular(24),

        ),
        onPressed: (){
          Navigator.of(context).pushNamed(LoginPage.tag);
        },
        padding: EdgeInsets.all(12),
        color: Colors.orange.shade100,
        child:Text('SignUp',style:TextStyle(color:Colors.brown.shade900,fontSize: 20)),
      ),


    );

    final forgot_label = FlatButton(
    child: Text(
    'Already have an account?',
    
    style:TextStyle(color: Colors.brown,decorationStyle:TextDecorationStyle.double,fontSize: 20),
    ),
    onPressed: () {
    Navigator.push
    (
    context,
    MaterialPageRoute(builder: (context)
    {
    return new LoginPage();
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
            username,
            SizedBox(height: 15.0),
            email,
            SizedBox(height: 15.0),
            pass,
            SizedBox(height: 24.0),
            sign_up_btn,
            forgot_label


          ],
        ),
      ),
    );

  }
}
