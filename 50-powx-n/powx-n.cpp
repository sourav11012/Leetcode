class Solution {
public:
    double fn(double x, long n)
    {
        if(n == 1 )
        {
            return x;
        }
        if(n == 0)
        {
            return 1;
        }

        if(n % 2 == 0)
        {
            return fn(x * x, n /2);
        }else{
            return x * fn(x , n - 1);
        }
    }
    // 2.100 * 2.100 ~ 4.4100 
    // 4.41 * 2 
    double myPow(double x, int n) {
    
        if(n < 0)
        {
            
            return 1.0 / fn(x, -1 * (long)n);
        }
        
        return fn(x, n);

       

        


    }
};