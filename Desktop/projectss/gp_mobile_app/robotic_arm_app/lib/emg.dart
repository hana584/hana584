import 'package:flutter/material.dart';
import 'package:http/http.dart' as http;
import 'package:robotic_arm_app/Moves.dart';
import 'dart:convert';
import 'home.dart';
class Emg extends StatefulWidget {
  @override
  _EmgState createState() => _EmgState();
}

class _EmgState extends State<Emg> {
  String g = '';
  bool signals=false;
  Widget logButton(){

  return FlatButton(onPressed:()
  {
     Navigator.push
        (
            context,
            MaterialPageRoute(builder: (context)
        {
          return new HomePage();
        })


);

  },
  child:Text('Back',style:TextStyle(color:Colors.red,fontSize: 20)));

}
final logo =Hero(tag: 'hero', child: CircleAvatar(
      backgroundColor: Colors.transparent,
      radius: 150.0,
      child:Image.asset('assets/EMG.png'),
    ),

    );
Widget doWorkButton(){
if(signals){
  return RaisedButton(onPressed:()
  {
    Navigator.push
        (
            context,
            MaterialPageRoute(builder: (context)
        {
          return new MOVES();
        })


);

  },
  child:Text('DO Your Moves',style:TextStyle(color:Colors.red.shade900,fontSize: 30)));
}
else
return Container();
 final loginBtn = Padding(
      padding: EdgeInsets.symmetric(vertical: 16.0),
      child: RaisedButton(
        shape: RoundedRectangleBorder(
          borderRadius: BorderRadius.circular(24),

        ),
        onPressed: () async {
                    //async function to perform http get
                    var url = 'http://10.0.2.2:5000/';
                    final response = await http.get(Uri.parse(
                        url)); 
                        //getting the response from our backend server script
                    print(response.statusCode);
                    final decoded = json.decode(response.body) as Map<String,
                        dynamic>;
                         //converting it from json to key value pair

                    setState(() {
                      g = decoded[
                          'greet']; 
                          //changing the state of our widget on data update
                      
                          signals=true;
                    });
                  },
        padding: EdgeInsets.all(12),
        color: Colors.lightBlueAccent,
        child:Text('Log In',style:TextStyle(color:Colors.white,fontSize: 36)),
      ),

    );

}
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      body: Container(
        child: Column(

          mainAxisAlignment: MainAxisAlignment.spaceEvenly,
          children: [
            logo,
            doWorkButton(),
            Text(g, //Text that will be displayed on the screen
                style: TextStyle(fontSize: 24, fontWeight: FontWeight.bold,color:Colors.red.shade900)),
            Center(
              child: Container(
                //container that contains the button
                width: 230,
                height: 150,
                child:  Padding(
      padding: EdgeInsets.symmetric(vertical: 16.0),
      child: RaisedButton(
        shape: RoundedRectangleBorder(
          borderRadius: BorderRadius.circular(24),

        ),
        onPressed: () async {
                    //async function to perform http get
                    var url = 'http://10.0.2.2:5000/';
                    final response = await http.get(Uri.parse(
                        url)); 
                        //getting the response from our backend server script
                    print(response.statusCode);
                    final decoded = json.decode(response.body) as Map<String,
                        dynamic>;
                         //converting it from json to key value pair

                    setState(() {
                      g = decoded[
                          'greet']; 
                          //changing the state of our widget on data update
                      
                          signals=true;
                    });
                  },
        padding: EdgeInsets.all(12),
        color: Colors.orange.shade100,
        child:Text('Start',style:TextStyle(color:Colors.brown.shade900,fontSize: 25)),
      ),

    )
              ),
              
            ),
            logButton(),
          ],
        ),
      ),
    );
  }
}
