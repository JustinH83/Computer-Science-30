package code;

import java.util.Scanner;

public class SearchingAndSorting {
	
	public static int getDigit(int num, int digit) {
		return (int)(num%Math.pow(10,digit+1)/Math.pow(10,digit));
	}
	public static void menu() {
		System.out.println("0. Exit Program");
		System.out.println("1. Populate array sequencially from 1-100");
		System.out.println("2. Populate the array randomly with numbers from 1 to 100");
		System.out.println("3. Check if the array is sorted");
		System.out.println("4. Display the array to the screen in a neatly arranged grid with numbers aligned in rows and columns");
		System.out.println("5. Shuffle the array");
		System.out.println("6. Search for a certain number using a linear search");
		System.out.println("7. Search for a certain number using a binary search");
		System.out.println("8. Sort the array using bubble sort");
		System.out.println("9. Sort the array using selection sort");
		System.out.println("10. Sort the array using insertion sort");
		System.out.println("11. Sort the array using radix sort");
		System.out.println("12. Sort the array using quick sort");
		System.out.println("13. Sort the array using merge sort");
	}
	public static void sequential(int[]manta) {
		for(int x=0; x<manta.length; x++) {
			manta[x]=x+1;
		}
	}
	public static void random(int[]manta) {
		for(int x=0; x<manta.length; x++) {
			manta[x]=(int)(Math.random()*100+1);
		}
	}
	public static boolean sorted(int[]manta) {
		for(int x=0; x<manta.length-1; x++) {
			if(manta[x]>manta[x+1])
				return false;
		}
		return true;
	}
	public static void display(int[]manta) {
		for(int x=0; x<manta.length; x++) {
			if(x%10==0)
				System.out.println("");
			if((int)(manta[x]/10)==0)
				System.out.print(manta[x] + "   ");
			else if((int)(manta[x]/100)==0)
				System.out.print(manta[x] + "  ");
			else
				System.out.print(manta[x] + " ");
		}
		System.out.println("");
	}
	public static int[] shuffle(int[]manta) {
		int[] shuffled = new int[manta.length];
		int position;
		for(int x=0; x<manta.length; x++) 
			shuffled[x]=-1;	
		for(int x=0; x<manta.length; x++) {
			do {
				position = (int)(Math.random()*manta.length);
			}while(shuffled[position]!=-1);
			shuffled[position] = manta[x];
		}
		return shuffled;
	}
	public static int linearSearch(int[]manta, int target) {
		for(int x=0; x<manta.length;x++)
			if(manta[x]==target)
				return x;
		return -1;
	}
	
	public static int binarySearch(int[]manta, int target) {
		int leftBound = 0;
		int rightBound = manta.length-1;
		int midPoint;
		if(manta[leftBound] == target)
			return leftBound;
		if(manta[rightBound] == target) {
			while(manta[rightBound]==manta[rightBound-1])
				rightBound--;
			return rightBound;
		}
		while(rightBound - leftBound >1) {
			midPoint = (rightBound + leftBound)/2;
			if(manta[midPoint] == target) {
				while(manta[midPoint]==manta[midPoint-1]) 
					midPoint--;
				return midPoint;
			}
			if(target>manta[midPoint])
				leftBound = midPoint;
			else
				rightBound = midPoint;
		} 
		System.out.println(target + " is not in the array");
		return 0;
	}
	public static void bubbleSort(int[]manta) {
		boolean repeat = true;
		do {
			repeat = false;
			for(int x=0; x<manta.length-1;x++) {
				if(manta[x]>manta[x+1]) {
					int store = manta[x];
					manta[x] = manta[x+1];
					manta[x+1] = store;
					repeat = true;
				}
			}
		}while(repeat==true);
	}
	public static void selectionSort(int[]manta) {
		for(int x =0; x<manta.length;x++) {
			int lowest = manta[x];
			int store;
			int position=x;
			int y;
			for(y = x;y<manta.length;y++) {
				if(manta[y]<lowest) {
					lowest = manta[y];
					position = y;
				}
			}
			if(manta[x]==lowest)
				continue;
			store = manta[x];
			manta[x] = manta[position];
			manta[position] = store;
		}
	}
	public static void insertionSort(int[]manta) {
		int count;
		int store;
		for(int x =1; x<manta.length;x++) {
			count = x;
			while(count>0 && manta[count]<manta[count-1]) {
				store = manta[count];
				manta[count]=manta[count-1];
				manta[--count]=store;
			} 
		}
	}
	public static void radixSort(int[]manta) {
		int[] copy = new int[manta.length];
		int position;
		for(int y =0; y<3;y++) {
			position=0;
			for (int z=0; z<10;z++) {
				for(int x =0; x<manta.length;x++) {  
					if(getDigit(manta[x],y)==z) {
						copy[position] = manta[x];
						position++;
					}
				}
			}
			for(int x = 0; x<manta.length;x++)
				manta[x] = copy[x];
		}
	}
	public static void quickSort(int[]array, int begin, int end) {
		int left = begin;
		int right = end;
		int store;
		while(right!=left) {
			while(array[right] >= array[left] && right>left) 
				right--;
			store = array[right];
			array[right] = array[left];
			array[left] = store;
			while(array[left] <= array[right] && right>left) 
				left++;
			store = array[right];
			array[right] = array[left];
			array[left] = store;
		}
		if(left - begin >1)
			quickSort(array, begin, left-1);
		if(end - right > 1)
			quickSort(array, right+1, end);
	}
	public static void mergeSort(int[]array, int begin, int end) {
		int left = begin;
		int right = (end+begin)/2+1;
		int[] temp = new int[end-begin+1];
		int position = 0;
		if(end-begin>1) {
			mergeSort(array, begin, (end+begin)/2);
			mergeSort(array, (end+begin)/2+1, end);
		}
		for(int x = 0; x<temp.length; x++) {
			if(right==end+1) {
				while(position<temp.length) {
					temp[position] = array[left];
					left++;
					position++;
				}
				break;
			}  
			if(left==(end+begin)/2+1) {
				while(position<temp.length) {
					temp[position] = array[right];
					right++;
					position++;
				}
				break;
			}
			if(array[left]>array[right]) {
				temp[position] = array[right];
				right++;
				position++;
			}
			else {
				temp[position] = array[left];
				left++;
				position++;
			}
		}
		for(int x = 0; x<temp.length;x++)
			array[x+begin] = temp[x];
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] manta = new int[100];
		Scanner input = new Scanner(System.in);
		int number;
		do {
			menu();
			number=input.nextInt();
			if(number==1) {
				sequential(manta);
				System.out.println("Array populated sequentially");
			}
			else if(number ==2) {
				random(manta);
				System.out.println("Array populated randomly");
			}
			else if(number==3) {
				boolean check = sorted(manta);
				if(check==true)
					System.out.println("The array is in sequential order");
				else
					System.out.println("The array is not in sequential order");
			}
			else if(number==4)
				display(manta);
			else if(number ==5) {
				manta = shuffle(manta);
				System.out.println("Array shuffled");
			}
			else if(number==6) {
				System.out.println("Choose a number to find");
				int target = input.nextInt();
				System.out.println(linearSearch(manta,target));
			}
			else if(number==7) {
				System.out.println("Choose a number to find");
				int target = input.nextInt();
				System.out.println(binarySearch(manta,target));
			}
			else if(number==8) {
				bubbleSort(manta);
				System.out.println("The array has been sorted using bubble sort");
			}
			else if(number==9) {
				selectionSort(manta);
				System.out.println("The array has been sorted using selection sort");
			}
				else if(number==10) {
				insertionSort(manta);
				System.out.println("The array has been sorted using insertion sort");
			}
			else if(number==11) {
				radixSort(manta);
				System.out.println("The array has been sorted using radix sort");
			}
			else if(number==12) {
				quickSort(manta, 0, manta.length-1);
				System.out.println("The array has been sorted using quick sort");
			}
			else if(number==13) {
				mergeSort(manta, 0, manta.length-1);
				System.out.println("The array has been sorted using merge sort");
			}
		}while(number!=0);
	}

}
