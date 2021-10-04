import 'package:flutter/material.dart';
import 'home.dart';
import 'emg.dart';
import 'login_page.dart';
class movess extends StatefulWidget {
  @override
  _movessState createState() => _movessState();
}

class _movessState extends State<movess> {
  @override
  Widget build(BuildContext context) {
    final ttext = Padding(
        padding: EdgeInsets.all(30),
        child: Text(
          'Your Predicted Move is Arm Lift Down ',
          textAlign: TextAlign.start,
          style: TextStyle(fontSize:24,color: Colors.red.shade900,
          decorationStyle:TextDecorationStyle.double),
        ),
    );
final mov = Padding(
      padding: EdgeInsets.symmetric(vertical: 20.0),
      child: RaisedButton(
        shape: RoundedRectangleBorder(
          borderRadius: BorderRadius.circular(24),

        ),
        onPressed: (){
           Navigator.push
        (
            context,
            MaterialPageRoute(builder: (context)
        {
          return new HomePage();
        })


);
        },
        padding: EdgeInsets.all(20),
        color: Colors.orange.shade100,
        child:Text('Do Another Move',style:TextStyle(color:Colors.brown.shade900,fontSize: 24)),
      ),

    );
     final log_out = FlatButton(
      child: Text(
        'Log Out',
        style:TextStyle(color: Colors.red,fontSize: 24),
        
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
            
            
            ttext,
             SizedBox(height: 45.0),
            mov,
            SizedBox(height: 50.0),
            log_out


          ],
        ),
      ),
    );
    
  }
}
