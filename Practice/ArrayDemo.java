class ArrayDemo
{ public static void main(String[]args)
{ int arr[]={10,20,30,50,90};
for(int i: arr) {
	System.out.println("Using For Each loop:"+i);
}
for (int i=0;i<arr.length;i++)	{
	System.out.println("ARRAY INPUT AT INDEX "+i+" :" +arr[i]);
} System.out.println("UPDATING ARRAY ELEMENT:");
arr[3]=100;
System.out.println(arr[0]);
System.out.println(arr[1]);
System.out.println(arr[2]);
System.out.println(arr[3]);
System.out.println(arr[4]);

}

}

