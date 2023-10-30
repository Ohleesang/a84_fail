package com.example.a84

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        /**
         * 대괄호, 중괄호, 그리고 소괄호로 이루어진 문자열 s가 매개변수로 주어집니다.
         * 이 s를 왼쪽으로 x (0 ≤ x < (s의 길이)) 칸만큼 회전시켰을 때
         * s가 올바른 괄호 문자열이 되게 하는 x의 개수를
         * return 하도록 solution 함수를 완성해주세요.
         *
         * 1.대괄호,중괄호 ,소괄호 가 올바른지 대한 알고리즘
         * 2.왼쪽에 한칸만큼 움직이는 알고리즘 필요
         *
         */
        class Solution {
            //올바른 괄호인지 확인 하는 함수
            fun isCheckBrckets(s : String):Boolean {
                // 0 1 2 3 4 5
                // [ ] { } ( )
                // f f f f f f
                // stack 형 자료구조를 이해하면 쉽긴하겠네 근데 왜 런타임오류지?
                var isAbleBrckets :IntArray = IntArray(6,{0})
                var answer = true

                for(i in 0..s.length-1){
                    // 0,2,4 가 먼저 t가잡혀야한다. 그 이외는 f로 반환
                    when(s[i]){

                        '[' -> isAbleBrckets[0] ++

                        ']' -> if(isAbleBrckets[0]!=0) isAbleBrckets[0] --
                        else return false

                        '{' -> isAbleBrckets[2] ++

                        '}' -> if(isAbleBrckets[2]!=0) isAbleBrckets[2] --
                        else return false

                        '(' -> isAbleBrckets[4] ++

                        ')' -> if(isAbleBrckets[4]!=0) isAbleBrckets[4] --
                        else return false
                    }
                    //괄호가 완성되면 이때 다시 false 로 반환? x
                    //"(([]))"처럼 중복처리를 확인못하니 Int로바꾸자!
                    //반복문이 끝나면 모든값이 0이면 true로 반환하자!
                }
                for(i in 0..s.length-1){
                    if(isAbleBrckets[i]!=0) return false
                }

                return answer
            }
            //왼쪽에 한칸이 옮기는 함수
            fun takeLeftString(s: String) : String{
                var answer=""
                var temp = ""
                temp = s.substring(0..s.length-2)
                answer = s[s.length-1] + temp
                return answer
            }

            fun solution(s: String): Int {
                var answer: Int = 0
                var result = s
                for(i in 0..s.length-1){
                    if(isCheckBrckets(result)) answer++
                    result = takeLeftString(result)
                }
                return answer
            }
        }
        val a = Solution()
        a.solution("[](){}")
        a.solution("}]()[{")
        a.solution("[)(]")
        a.solution("}}}")
    }
}