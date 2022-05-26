import UIKit
import Foundation

print(Calendar.current.identifier)

let wantDate = Date(timeIntervalSinceNow: -2 * 60 * 60 * 24)

let gregorian = Calendar.current.dateComponents([.year, .month, .day], from: wantDate)

let jpCal = Calendar(identifier: .japanese).dateComponents([.year, .month, .day], from: wantDate)

let thaiCal = Calendar(identifier: .buddhist).dateComponents([.year, .month, .day], from: wantDate)

